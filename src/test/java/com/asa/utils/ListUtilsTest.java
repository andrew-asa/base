package com.asa.utils;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author andrew_asa
 * @date 2018/10/15.
 */
public class ListUtilsTest {

    @Test
    public void arrayToList() throws Exception {

    }

    @Test
    public void contain() throws Exception {

    }

    @Test
    public void length() throws Exception {

        Assert.assertEquals(1, ListUtils.length(ArrayUtils.arrayToList(new String[]{"a"})));
        Assert.assertEquals(0, ListUtils.length(ArrayUtils.arrayToList(new String[]{})));
        Assert.assertEquals(0, ListUtils.length(null));
    }

    @Test
    public void isEmpty() throws Exception {

        Assert.assertTrue(ListUtils.isEmpty(null));
        Assert.assertTrue(ListUtils.isEmpty(new ArrayList()));
        Assert.assertFalse(ListUtils.isNotEmpty(null));
        Assert.assertFalse(ListUtils.isNotEmpty(new ArrayList()));
        Assert.assertTrue(ListUtils.isNotEmpty(ArrayUtils.arrayToList(new String[]{"a"})));
    }

    @Test
    public void isNotEmpty() throws Exception {

    }

    @Test
    public void putIfAbsent() throws Exception {

    }
}
