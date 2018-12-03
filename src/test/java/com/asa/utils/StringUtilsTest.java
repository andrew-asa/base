package com.asa.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author andrew_asa
 * @date 2018/10/16.
 */
public class StringUtilsTest {

    @Test
    public void startsWith() throws Exception {

        String str = null;
        Assert.assertFalse(StringUtils.startsWith(str, "a"));
        str = "ab";
        Assert.assertFalse(StringUtils.startsWith(str, null));
        Assert.assertTrue(StringUtils.startsWith(str, "ab"));
    }

    @Test
    public void length() throws Exception {

        String str = null;
        Assert.assertEquals(StringUtils.length(str), 0);
        str = "";
        Assert.assertEquals(StringUtils.length(str), 0);
        str = "ab";
        Assert.assertEquals(StringUtils.length(str), 2);
        str = "中文";
        Assert.assertEquals(StringUtils.length(str), 2);

    }

    @Test
    public void containsIgnoreCase() throws Exception {

        String str1 = "abcDefGHiGk";
        String str2 = "ab";
        Assert.assertTrue(StringUtils.containsIgnoreCase(str1, str2));
        str2 = "Bc";
        Assert.assertTrue(StringUtils.containsIgnoreCase(str1, str2));
        str2 = "cd";
        Assert.assertTrue(StringUtils.containsIgnoreCase(str1, str2));
        str2 = null;
        Assert.assertFalse(StringUtils.containsIgnoreCase(str1, str2));
    }

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
