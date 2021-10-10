package com.asa.base.utils.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class IOUtilsTest {

    @Test
    public void closeQuietly() throws Exception {

    }

    @Test
    public void inputStream2Bytes() {

        byte[] bytes = IOUtils.inputStream2Bytes(null);
        Assert.assertEquals(bytes.length, 0);
        byte[] bi = new byte[2];
        bi[0] = 1;
        bi[1] = 2;
        ByteArrayInputStream in = new ByteArrayInputStream(bi);
        byte[] bo = IOUtils.inputStream2Bytes(in);
        Assert.assertEquals(bo.length, bi.length);
        Assert.assertEquals(bo[0], bi[0]);
        Assert.assertEquals(bo[1], bi[1]);
    }


}