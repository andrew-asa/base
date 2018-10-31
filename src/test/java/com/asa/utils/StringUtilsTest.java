package com.asa.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author andrew_asa
 * @date 2018/10/16.
 */
public class StringUtilsTest {

    @Test
    public void isEmpty() throws Exception {
        String fs = "abs{}ccc";
        Assert.assertTrue(StringUtils.isEmpty(null));
        Assert.assertTrue(StringUtils.isEmpty(""));
        Assert.assertFalse(StringUtils.isNotEmpty(null));
        Assert.assertFalse(StringUtils.isNotEmpty(""));
        Assert.assertFalse(StringUtils.isEmpty(fs));
        Assert.assertTrue(StringUtils.isNotEmpty(fs));
    }

    @Test
    public void messageFormat() throws Exception {

        String fs = "abs{}ccc";
        String ret = StringUtils.messageFormat(fs, 1);
        Assert.assertEquals(ret, "abs1ccc");
        String[] args = new String[]{"a", "b"};
        ret = StringUtils.messageFormat(fs, args);
        Assert.assertEquals(ret, "absaccc");
    }
}
