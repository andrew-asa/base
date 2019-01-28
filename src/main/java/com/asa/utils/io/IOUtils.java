package com.asa.utils.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class IOUtils {

    /**
     * 关闭
     *
     * @param closes
     */
    public static void closeQuietly(Closeable... closes) {

        for (Closeable close : closes) {
            if (close != null) {
                try {
                    close.close();
                } catch (IOException e) {
                    // Ignored
                }
            }
        }
    }
}
