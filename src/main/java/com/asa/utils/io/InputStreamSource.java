package com.asa.utils.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author andrew_asa
 * @date 2021/9/28.
 */
public interface InputStreamSource {

    InputStream getInputStream() throws IOException;
}
