package com.asa.base.utils;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andrew_asa
 * @date 2018/10/15.
 */
public class ListUtilsTest {

    @Test
    public void contain() throws Exception {

        List<String> list = ArrayUtils.arrayToList(new String[]{"a"});
        Assert.assertTrue(ListUtils.contain(list, "a"));
        Assert.assertFalse(ListUtils.contain(list, "b"));
        Assert.assertFalse(ListUtils.contain(null, "b"));
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
}
