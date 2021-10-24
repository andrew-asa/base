package com.asa.base.utils.io;

import com.asa.base.log.LoggerFactory;
import com.asa.base.utils.EncodeConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author andrew_asa
 * @date 2021/3/10.
 */
public class FileUtils {

    /**
     * 更新最后修改时间
     * 文件不存在就新建
     *
     * @param file
     * @throws IOException
     */
    public static void touch(File file) throws IOException {

        if (!file.exists()) {
            OutputStream out = openOutputStream(file);
            IOUtils.closeQuietly(out);
        }
        boolean success = file.setLastModified(System.currentTimeMillis());
        if (!success) {
            throw new IOException("Unable to set the last modification time for " + file);
        }
    }

    public static FileOutputStream openOutputStream(File file) throws IOException {

        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (file.canWrite() == false) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File parent = file.getParentFile();
            if (parent != null && parent.exists() == false) {
                if (parent.mkdirs() == false) {
                    throw new IOException("File '" + file + "' could not be created");
                }
            }
        }
        return new FileOutputStream(file);
    }

    /**
     * 删除文件
     *
     * @param file
     */
    public static void deleteFile(File file) {

        if (file.isFile()) {
            LoggerFactory.getLogger().debug("delete {}", file.getAbsoluteFile());
            file.delete();
        } else {
            String[] childFilePath = file.list();
            for (String path : childFilePath) {
                File childFile = new File(file.getAbsoluteFile() + "/" + path);
                deleteFile(childFile);
            }
            LoggerFactory.getLogger().debug("delete {}", file.getAbsoluteFile());
            file.delete();
        }
    }

    /**
     * 强制生成文件夹
     *
     * @param directory
     * @throws IOException
     */
    public static void forceMkdir(File directory) throws IOException {

        if (directory.exists()) {
            if (directory.isFile()) {
                String message =
                        "File "
                                + directory
                                + " exists and is "
                                + "not a directory. Unable to create directory.";
                throw new IOException(message);
            }
        } else {
            if (!directory.mkdirs()) {
                String message =
                        "Unable to create directory " + directory;
                throw new IOException(message);
            }
        }
    }

    /**
     * 强制生成目录
     *
     * @param directory
     * @throws IOException
     */
    public static void forceMkdir(String directory) throws IOException {

        forceMkdir(new File(directory));
    }

    /**
     * 目录长度
     *
     * @param directory
     * @return
     */
    public static long sizeOfDirectory(File directory) {

        if (!directory.exists()) {
            String message = directory + " does not exist";
            throw new IllegalArgumentException(message);
        }

        if (!directory.isDirectory()) {
            String message = directory + " is not a directory";
            throw new IllegalArgumentException(message);
        }

        long size = 0;

        File[] files = directory.listFiles();
        if (files == null) {  // null if security restricted
            return 0L;
        }
        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            if (file.isDirectory()) {
                size += sizeOfDirectory(file);
            } else {
                size += file.length();
            }
        }

        return size;
    }

    /**
     * 文件复制
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile) throws IOException {

        copyFile(srcFile, destFile, true);
    }

    /**
     * 复制文件
     *
     * @param srcFile
     * @param destFile
     * @param preserveFileDate 是否复制最后修改时间
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile,
                                boolean preserveFileDate) throws IOException {

        if (srcFile == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (destFile == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (srcFile.exists() == false) {
            throw new FileNotFoundException("Source '" + srcFile + "' does not exist");
        }
        if (srcFile.isDirectory()) {
            throw new IOException("Source '" + srcFile + "' exists but is a directory");
        }
        if (srcFile.getCanonicalPath().equals(destFile.getCanonicalPath())) {
            throw new IOException("Source '" + srcFile + "' and destination '" + destFile + "' are the same");
        }
        if (destFile.getParentFile() != null && destFile.getParentFile().exists() == false) {
            if (destFile.getParentFile().mkdirs() == false) {
                throw new IOException("Destination '" + destFile + "' directory cannot be created");
            }
        }
        if (destFile.exists() && destFile.canWrite() == false) {
            throw new IOException("Destination '" + destFile + "' exists but is read-only");
        }
        doCopyFile(srcFile, destFile, preserveFileDate);
    }

    /**
     * 复制整个文件夹到新路径
     *
     * @param srcDir
     * @param destDir
     * @param preserveFileDate 文件修改文件是否和源文件一样
     * @throws NullPointerException if source or destination is <code>null</code>
     * @throws IOException          if source or destination is invalid
     * @throws IOException          if an IO error occurs during copying
     * @since Commons IO 1.1
     */
    public static void copyDirectory(File srcDir, File destDir,
                                     boolean preserveFileDate) throws IOException {

        if (srcDir == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (destDir == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (srcDir.exists() == false) {
            throw new FileNotFoundException("Source '" + srcDir + "' does not exist");
        }
        if (srcDir.isDirectory() == false) {
            throw new IOException("Source '" + srcDir + "' exists but is not a directory");
        }
        if (srcDir.getCanonicalPath().equals(destDir.getCanonicalPath())) {
            throw new IOException("Source '" + srcDir + "' and destination '" + destDir + "' are the same");
        }
        doCopyDirectory(srcDir, destDir, preserveFileDate);
    }

    /**
     * 文件夹下的文件全复制
     *
     * @param srcDir
     * @param destDir
     * @throws IOException
     */
    public static void copyDirectory(File srcDir, File destDir) throws IOException {

        copyDirectory(srcDir, destDir, true);
    }

    /**
     * 复制文件目录到新的目录
     *
     * @param srcDir
     * @param destDir
     * @throws IOException
     */
    public static void copyDirectoryToDirectory(File srcDir, File destDir) throws IOException {

        if (srcDir == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (srcDir.exists() && srcDir.isDirectory() == false) {
            throw new IllegalArgumentException("Source '" + destDir + "' is not a directory");
        }
        if (destDir == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (destDir.exists() && destDir.isDirectory() == false) {
            throw new IllegalArgumentException("Destination '" + destDir + "' is not a directory");
        }
        copyDirectory(srcDir, new File(destDir, srcDir.getName()), true);
    }

    /**
     * 文件转行迭代器
     *
     * @param file
     * @param encoding 编码类型
     * @return
     * @throws IOException
     */
    public static LineIterator lineIterator(File file, String encoding) throws IOException {

        InputStream in = null;
        try {
            in = openInputStream(file);
            return IOUtils.lineIterator(in, encoding);
        } catch (IOException ex) {
            IOUtils.closeQuietly(in);
            throw ex;
        } catch (RuntimeException ex) {
            IOUtils.closeQuietly(in);
            throw ex;
        }
    }

    /**
     * 文件转行迭代器,默认使用utf-8进行读取文件字符流
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static LineIterator lineIterator(File file) throws IOException {

        return lineIterator(file, EncodeConstants.ENCODING_UTF_8);
    }

    public static FileInputStream openInputStream(File file) throws IOException {

        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (file.canRead() == false) {
                throw new IOException("File '" + file + "' cannot be read");
            }
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        return new FileInputStream(file);
    }

    /**
     * 文件复制
     *
     * @param srcFile
     * @param destFile
     * @param preserveFileDate
     * @throws IOException
     */
    private static void doCopyFile(File srcFile, File destFile, boolean preserveFileDate) throws IOException {

        if (destFile.exists() && destFile.isDirectory()) {
            throw new IOException("Destination '" + destFile + "' exists but is a directory");
        }

        FileInputStream input = new FileInputStream(srcFile);
        try {
            FileOutputStream output = new FileOutputStream(destFile);
            try {
                IOUtils.copy(input, output);
            } finally {
                IOUtils.closeQuietly(output);
            }
        } finally {
            IOUtils.closeQuietly(input);
        }

        if (srcFile.length() != destFile.length()) {
            throw new IOException("Failed to copy full contents from '" +
                                          srcFile + "' to '" + destFile + "'");
        }
        if (preserveFileDate) {
            destFile.setLastModified(srcFile.lastModified());
        }
    }

    /**
     * 文件夹复制
     *
     * @param srcDir
     * @param destDir
     * @param preserveFileDate
     * @throws IOException
     */
    private static void doCopyDirectory(File srcDir, File destDir, boolean preserveFileDate) throws IOException {

        if (destDir.exists()) {
            if (destDir.isDirectory() == false) {
                throw new IOException("Destination '" + destDir + "' exists but is not a directory");
            }
        } else {
            if (destDir.mkdirs() == false) {
                throw new IOException("Destination '" + destDir + "' directory cannot be created");
            }
            if (preserveFileDate) {
                destDir.setLastModified(srcDir.lastModified());
            }
        }
        if (destDir.canWrite() == false) {
            throw new IOException("Destination '" + destDir + "' cannot be written to");
        }
        // recurse
        File[] files = srcDir.listFiles();
        if (files == null) {  // null if security restricted
            throw new IOException("Failed to list contents of " + srcDir);
        }
        for (int i = 0; i < files.length; i++) {
            File copiedFile = new File(destDir, files[i].getName());
            if (files[i].isDirectory()) {
                doCopyDirectory(files[i], copiedFile, preserveFileDate);
            } else {
                doCopyFile(files[i], copiedFile, preserveFileDate);
            }
        }
    }

    public static String systemFilePathToString(String path) throws IOException {

        FileSystemResource resource = new FileSystemResource(path);
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            return IOUtils.inputStream2String(inputStream);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }
}
