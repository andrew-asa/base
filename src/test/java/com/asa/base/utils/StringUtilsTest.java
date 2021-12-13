package com.asa.base.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author andrew_asa
 * @date 2018/10/16.
 */
public class StringUtilsTest {

    @Test
    public void equals() throws Exception {

        assertTrue(StringUtils.equals("a", "a"));
        assertFalse(StringUtils.equals("a", "A"));
        assertFalse(StringUtils.equals(null, "A"));
        assertTrue(StringUtils.equals(null, null));
        assertTrue(StringUtils.equals("aBa", "aBa"));
        assertFalse(StringUtils.equals("aba", "aBa"));
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

        assertTrue(StringUtils.isNotEmpty("a"));
        assertFalse(StringUtils.isNotEmpty(""));
        assertFalse(StringUtils.isNotEmpty(null));
    }

    @Test
    public void doubleToString() throws Exception {

    }

    @Test
    public void equalsIgnoreCase() throws Exception {

        assertTrue(StringUtils.equalsIgnoreCase("abc", "ABC"));
        assertFalse(StringUtils.equalsIgnoreCase("abc", "bBC"));
    }

    @Test
    public void split() throws Exception {

        String[] ab = StringUtils.split("abc", "ab");
        assertTrue(ab.length == 2);
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
        assertFalse(StringUtils.startsWith(str, "a"));
        str = "ab";
        assertFalse(StringUtils.startsWith(str, null));
        assertTrue(StringUtils.startsWith(str, "ab"));
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
        assertTrue(StringUtils.containsIgnoreCase(str1, str2));
        str2 = "Bc";
        assertTrue(StringUtils.containsIgnoreCase(str1, str2));
        str2 = "cd";
        assertTrue(StringUtils.containsIgnoreCase(str1, str2));
        str2 = null;
        assertFalse(StringUtils.containsIgnoreCase(str1, str2));
    }

    @Test
    public void isEmpty() throws Exception {

        String fs = "abs{}ccc";
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isNotEmpty(null));
        assertFalse(StringUtils.isNotEmpty(""));
        assertFalse(StringUtils.isEmpty(fs));
        assertTrue(StringUtils.isNotEmpty(fs));
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

        assertFalse(StringUtils.endWith(null, ""));
        assertFalse(StringUtils.endWith("", null));
        assertTrue(StringUtils.endWith(null, null));
        assertTrue(StringUtils.endWith("abc", "c"));
        assertFalse(StringUtils.endWith("abc", "b"));
    }

    @Test
    public void startWith() {

        assertFalse(StringUtils.startsWith(null, ""));
        assertFalse(StringUtils.startsWith("", null));
        assertTrue(StringUtils.startsWith(null, null));
        assertTrue(StringUtils.startsWith("abc", "a"));
        assertFalse(StringUtils.startsWith("abc", "b"));
    }

    @Test
    public void startsWithListItem() {
        List<String> l = Arrays.asList("abc","edf");
        assertFalse(StringUtils.startsWithListItem(null, l));
        assertFalse(StringUtils.startsWithListItem("aedf", l));
        assertTrue(StringUtils.startsWithListItem("abcedf", l));
        assertTrue(StringUtils.startsWithListItem("edfabc", l));
        assertFalse(StringUtils.startsWithListItem("edfabc", null));
    }

    @Test
    public void contains() {

        assertFalse(StringUtils.contains("aedf", "lll"));
        assertFalse(StringUtils.contains("aedf", "af"));
        assertFalse(StringUtils.contains(null, "af"));
        assertFalse(StringUtils.contains("null", null));
        assertFalse(StringUtils.contains(null, null));
        assertTrue(StringUtils.contains("aedf", "a"));
        assertTrue(StringUtils.contains("aedf", "ae"));
        assertTrue(StringUtils.contains("aedf", "aed"));
        assertTrue(StringUtils.contains("aedf", "aedf"));
        assertTrue(StringUtils.contains("aedf", "df"));
        assertTrue(StringUtils.contains("aedf", "ed"));
        assertTrue(StringUtils.contains("aedf", "edf"));

    }

    @Test
    public void containsItem() {
        List<String> l = Arrays.asList("abc","edf");
        assertFalse(StringUtils.containsItem(null, l));
        assertFalse(StringUtils.containsItem(null, null));
        assertFalse(StringUtils.containsItem("null", null));
        assertTrue(StringUtils.containsItem("abcedf", l));
        assertTrue(StringUtils.containsItem("edfgg", l));
        assertTrue(StringUtils.containsItem("abceee", l));
        assertFalse(StringUtils.containsItem("aefeee", l));
    }

    @Test
    public void replaceFirst() {

        String in = "abcefcabc";
        Assert.assertEquals(StringUtils.replaceFirst(in,"abc",""),"efcabc");
        Assert.assertNull(StringUtils.replaceFirst(null,"abc",""));
        Assert.assertEquals(StringUtils.replaceFirst(in,"abc",null),in);
    }

    @Test
    public void replace() {
        String in = "abcefcabc";
        Assert.assertEquals(StringUtils.replace(in,"abc",""),"efc");
    }

    @Test
    public void testClone() {

    }

    @Test
    public void ifEmpty() {

    }

    @Test
    public void testIsBlank() {
        assertTrue(StringUtils.isBlank(null));
        assertTrue(StringUtils.isBlank(""));
        assertFalse(StringUtils.isBlank("foo"));
        assertFalse(StringUtils.isBlank("  foo  "));
    }

    @Test
    public void testIsNotBlank() {
        assertFalse(StringUtils.isNotBlank(null));
        assertFalse(StringUtils.isNotBlank(""));
        assertTrue(StringUtils.isNotBlank("foo"));
        assertTrue(StringUtils.isNotBlank("  foo  "));
    }

    @Test
    public void delimitedListToStringArray() {

    }

    @Test
    public void testDelimitedListToStringArray() {

    }

    @Test
    public void delete() {

    }

    @Test
    public void deleteAny() {

    }

    @Test
    public void toStringArray() {

    }

    @Test
    public void collectionToDelimitedString() {

    }

    @Test
    public void testCollectionToDelimitedString() {

    }

    @Test
    public void collectionToCommaDelimitedString() {

    }
}
