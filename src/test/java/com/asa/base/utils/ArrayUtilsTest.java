package com.asa.base.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;


/**
 * @author andrew_asa
 * @date 2018/10/31.
 */
public class ArrayUtilsTest {

    @Test
    public void length() throws Exception {

        String[] items = {"bcd", "abe", "dd", "ecf"};
        Assert.assertEquals(ArrayUtils.length(items), 4);
        Assert.assertEquals(ArrayUtils.length(null), 0);
        Assert.assertEquals(ArrayUtils.length(new String[0]), 0);
    }

    @Test
    public void indexOf() throws Exception {

        String s1 = "abc";
        String[] items = {"bcd", "abe", s1, "ecf"};
        Assert.assertEquals(ArrayUtils.indexOf(items, s1), 2);
        Assert.assertEquals(ArrayUtils.indexOf(items, "ecff"), -1);
    }

    @Test
    public void toIterator() {

        String[] items = null;
        Iterator<String> iterator = ArrayUtils.toIterator(items);
        Assert.assertNotNull(iterator);
        Assert.assertFalse(iterator.hasNext());

        items = new String[]{"bcd", "abe", "dd", "ecf"};
        iterator = ArrayUtils.toIterator(items);
        Assert.assertNotNull(iterator);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(items[0], iterator.next());

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(items[1], iterator.next());

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(items[2], iterator.next());

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(items[3], iterator.next());

        Assert.assertFalse(iterator.hasNext());
    }


    @Test
    public void toReverseIterator() {

        String[] items = null;
        Iterator<String> iterator = ArrayUtils.toReverseIterator(items);
        Assert.assertNotNull(iterator);
        Assert.assertFalse(iterator.hasNext());

        items = new String[]{"bcd", "abe", "dd", "ecf"};
        iterator = ArrayUtils.toReverseIterator(items);
        Assert.assertNotNull(iterator);

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(items[3], iterator.next());

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(items[2], iterator.next());

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(items[1], iterator.next());

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(items[0], iterator.next());

        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void arrayToList() {

    }

    @Test
    public void contains() {

    }

    @Test
    public void subarray() {

    }

    @Test
    public void testSubarray() {

        final byte[] nullArray = null;
        final byte[] array = {10, 11, 12, 13, 14, 15};
        final byte[] leftSubarray = {10, 11, 12, 13};
        final byte[] midSubarray = {11, 12, 13, 14};
        final byte[] rightSubarray = {12, 13, 14, 15};

        Assert.assertTrue(ArrayUtils.isEquals(leftSubarray, ArrayUtils.subarray(array, 0, 4)));
        Assert.assertTrue(ArrayUtils.isEquals(array, ArrayUtils.subarray(array, 0, array.length)));
        Assert.assertTrue(ArrayUtils.isEquals(midSubarray, ArrayUtils.subarray(array, 1, 5)));
        Assert.assertTrue(ArrayUtils.isEquals(rightSubarray, ArrayUtils.subarray(array, 2, array.length)));
        Assert.assertNull(ArrayUtils.subarray(nullArray, 0, 3));
        Assert.assertTrue(ArrayUtils.isEquals(ArrayUtils.EMPTY_BYTE_ARRAY, ArrayUtils.subarray(ArrayUtils.EMPTY_BYTE_ARRAY, 1, 2)));
    }

    @Test
    public void isEquals() {

        byte[] array = {10, 11, 12, 13, 14, 15};
        Assert.assertTrue(ArrayUtils.isEquals(array, new byte[]{10, 11, 12, 13, 14, 15}));
        Assert.assertFalse(ArrayUtils.isEquals(array, new byte[]{10, 11, 12, 13, 14, 16}));
        Assert.assertFalse(ArrayUtils.isEquals(array, new byte[]{10}));
        Assert.assertFalse(ArrayUtils.isEquals(array, null));
        Assert.assertFalse(ArrayUtils.isEquals(null, new byte[]{10, 11, 12, 13, 14, 16}));
        Assert.assertTrue(ArrayUtils.isEquals(null, null));
    }
}