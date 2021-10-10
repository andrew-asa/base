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
}