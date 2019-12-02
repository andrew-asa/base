package com.asa.utils.io;

import com.asa.log.LoggerFactory;
import com.asa.third.org.apache.commons.lang3.ArrayUtils;
import com.asa.utils.EncodeConstants;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class IOUtils {

    public static final int BUF_MB = 32 * 1024;

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

    /**
     * @param in
     * @return
     */
    public static byte[] inputStream2Bytes(InputStream in) {

        if (in == null) {
            return new byte[0];
        }
        byte[] temp = new byte[BUF_MB];
        ByteArrayOutputStream bi = new ByteArrayOutputStream();
        try {
            int count;
            while ((count = in.read(temp)) > 0) {
                byte[] b4Add;
                if (temp.length == count) {
                    b4Add = temp;
                } else {
                    b4Add = ArrayUtils.subarray(temp, 0, count);
                }
                bi.write(b4Add);
            }
        } catch (IOException e) {
            LoggerFactory.getLogger().error(e.getMessage(), e);
        } finally {
            closeQuietly(in);
        }

        return bi.toByteArray();
    }


    /**
     * 从输入流中按UTF-8编码读取字符串
     *
     * @param is 输入流
     * @return 读取出来的字符串
     * @throws UnsupportedEncodingException
     */
    public static String inputStream2String(InputStream is)
            throws UnsupportedEncodingException {

        return new String(inputStream2Bytes(is), EncodeConstants.ENCODING_UTF_8);
    }
}
