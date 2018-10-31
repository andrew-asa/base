package com.asa.utils;

import org.junit.Assert;
import org.junit.Test;


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

}