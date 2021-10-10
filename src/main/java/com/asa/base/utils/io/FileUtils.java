package com.asa.base.utils.io;

import com.asa.base.log.LoggerFactory;

import java.io.File;

/**
 * @author andrew_asa
 * @date 2021/3/10.
 */
public class FileUtils {

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
}
