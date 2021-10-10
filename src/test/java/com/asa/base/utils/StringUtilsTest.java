package com.asa.base.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author andrew_asa
 * @date 2018/10/16.
 */
public class StringUtilsTest {

    @Test
    public void equals() throws Exception {

        Assert.assertTrue(StringUtils.equals("a", "a"));
        Assert.assertFalse(StringUtils.equals("a", "A"));
        Assert.assertFalse(StringUtils.equals(null, "A"));
        Assert.assertTrue(StringUtils.equals(null, null));
        Assert.assertTrue(StringUtils.equals("aBa", "aBa"));
        Assert.assertFalse(StringUtils.equals("aba", "aBa"));
    }

    @Test
    public void splitWithBlankAndSafeGetItem1() throws Exception {

        String[] ret = StringUtils.splitWithBlankAndSafeGetItem("abc cd ddd   e3ee", "dv", 0, 2, 3, 5);
        Assert.assertEquals(ret.length, 4);
        Assert.assertEquals(new String[]{"abc", "ddd", "e3ee", "dv"}, ret);
    }

    @Test
    public void splitWithBlankAndSafeGetItem() throws Exception {

        String ab = StringUtils.splitWithBlankAndSafeGetItem("abc cd ddd   e3ee", 3, "CCC");
        Assert.assertEquals(ab, "e3ee");
        Assert.assertEquals(StringUtils.splitWithBlankAndSafeGetItem("abc cd ddd   e3ee", 4, "CCC"), "CCC");
    }

    @Test
    public void isNotEmpty() throws Exception {

        Assert.assertTrue(StringUtils.isNotEmpty("a"));
        Assert.assertFalse(StringUtils.isNotEmpty(""));
        Assert.assertFalse(StringUtils.isNotEmpty(null));
    }

    @Test
    public void doubleToString() throws Exception {

    }

    @Test
    public void equalsIgnoreCase() throws Exception {

        Assert.assertTrue(StringUtils.equalsIgnoreCase("abc", "ABC"));
        Assert.assertFalse(StringUtils.equalsIgnoreCase("abc", "bBC"));
    }

    @Test
    public void split() throws Exception {

        String[] ab = StringUtils.split("abc", "ab");
        Assert.assertTrue(ab.length == 2);
    }

    @Test
    public void splitWithBlank() throws Exception {

        String[] ab = StringUtils.splitWithBlank("abc cd ddd   e3ee");
        Assert.assertEquals(ab.length, 4);
        Assert.assertEquals(ab[0], "abc");
        Assert.assertEquals(ab[1], "cd");
        Assert.assertEquals(ab[2], "ddd");
        Assert.assertEquals(ab[3], "e3ee");
    }

    @Test
    public void join() throws Exception {

        List<String> list = ListUtils.arrayToList("a", "b", "c");
        List<Integer> list2 = ListUtils.arrayToList(1, 2, 3);
        Assert.assertEquals(StringUtils.join(list, ","), "a,b,c");
        Assert.assertEquals(StringUtils.join(list, ""), "abc");
        Assert.assertEquals(StringUtils.join(list, null), "abc");
        Assert.assertEquals(StringUtils.join(list2, "$"), "1$2$3");
    }

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

    @Test
    public void clone1() {

    }

    @Test
    public void endWith() {

        Assert.assertFalse(StringUtils.endWith(null, ""));
        Assert.assertFalse(StringUtils.endWith("", null));
        Assert.assertTrue(StringUtils.endWith(null, null));
        Assert.assertTrue(StringUtils.endWith("abc", "c"));
        Assert.assertFalse(StringUtils.endWith("abc", "b"));
    }

    @Test
    public void startWith() {

        Assert.assertFalse(StringUtils.startsWith(null, ""));
        Assert.assertFalse(StringUtils.startsWith("", null));
        Assert.assertTrue(StringUtils.startsWith(null, null));
        Assert.assertTrue(StringUtils.startsWith("abc", "a"));
        Assert.assertFalse(StringUtils.startsWith("abc", "b"));
    }
}
