package com.asa.base.utils.io;

import com.asa.base.lang.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author andrew_asa
 * @date 2021/9/28.
 */
public abstract class AbstractResource implements Resource {

    @Override
    public boolean exists() {
        // Try file existence: can we find the file in the file system?
        try {
            return getFile().exists();
        }
        catch (IOException ex) {
            // Fall back to stream existence: can we open the stream?
            try {
                getInputStream().close();
                return true;
            }
            catch (Throwable isEx) {
                return false;
            }
        }
    }


    @Override
    public boolean isReadable() {
        return exists();
    }


    @Override
    public boolean isOpen() {
        return false;
    }


    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public URL getURL() throws IOException {
        throw new FileNotFoundException(getDescription() + " cannot be resolved to URL");
    }


    @Override
    public URI getURI() throws IOException {
        URL url = getURL();
        try {
            return ResourceUtils.toURI(url);
        }
        catch (URISyntaxException ex) {
            throw new NestedIOException("Invalid URI [" + url + "]", ex);
        }
    }

    /**
     * This implementation throws a FileNotFoundException, assuming
     * that the resource cannot be resolved to an absolute file path.
     */
    @Override
    public File getFile() throws IOException {
        throw new FileNotFoundException(getDescription() + " cannot be resolved to absolute file path");
    }

    /**
     * This implementation returns {@link Channels#newChannel(InputStream)}
     * with the result of {@link #getInputStream()}.
     * <p>This is the same as in {@link Resource}'s corresponding default method
     * but mirrored here for efficient JVM-level dispatching in a class hierarchy.
     */
    @Override
    public ReadableByteChannel readableChannel() throws IOException {
        return Channels.newChannel(getInputStream());
    }

    /**
     * This implementation reads the entire InputStream to calculate the
     * content length. Subclasses will almost always be able to provide
     * a more optimal version of this, e.g. checking a File length.
     * @see #getInputStream()
     */
    @Override
    public long contentLength() throws IOException {
        InputStream is = getInputStream();
        try {
            long size = 0;
            byte[] buf = new byte[256];
            int read;
            while ((read = is.read(buf)) != -1) {
                size += read;
            }
            return size;
        }
        finally {
            try {
                is.close();
            }
            catch (IOException ex) {
            }
        }
    }

    /**
     * This implementation checks the timestamp of the underlying File,
     * if available.
     * @see #getFileForLastModifiedCheck()
     */
    @Override
    public long lastModified() throws IOException {
        File fileToCheck = getFileForLastModifiedCheck();
        long lastModified = fileToCheck.lastModified();
        if (lastModified == 0L && !fileToCheck.exists()) {
            throw new FileNotFoundException(getDescription() +
                                                    " cannot be resolved in the file system for checking its last-modified timestamp");
        }
        return lastModified;
    }

    /**
     * Determine the File to use for timestamp checking.
     * <p>The default implementation delegates to {@link #getFile()}.
     * @return the File to use for timestamp checking (never {@code null})
     * @throws FileNotFoundException if the resource cannot be resolved as
     * an absolute file path, i.e. is not available in a file system
     * @throws IOException in case of general resolution/reading failures
     */
    protected File getFileForLastModifiedCheck() throws IOException {
        return getFile();
    }

    /**
     * This implementation throws a FileNotFoundException, assuming
     * that relative resources cannot be created for this resource.
     */
    @Override
    public Resource createRelative(String relativePath) throws IOException {
        throw new FileNotFoundException("Cannot create a relative resource for " + getDescription());
    }

    /**
     * This implementation always returns {@code null},
     * assuming that this resource type does not have a filename.
     */
    @Override
    public String getFilename() {
        return null;
    }


    /**
     * This implementation compares description strings.
     * @see #getDescription()
     */
    @Override
    public boolean equals(Object other) {
        return (this == other || (other instanceof Resource &&
                ((Resource) other).getDescription().equals(getDescription())));
    }

    /**
     * This implementation returns the description's hash code.
     * @see #getDescription()
     */
    @Override
    public int hashCode() {
        return getDescription().hashCode();
    }

    /**
     * This implementation returns the description of this resource.
     * @see #getDescription()
     */
    @Override
    public String toString() {
        return getDescription();
    }

}