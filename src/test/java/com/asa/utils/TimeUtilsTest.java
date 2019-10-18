package com.asa.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author andrew_asa
 * @date 2019-10-17.
 */
public class TimeUtilsTest {

    @Test
    public void testToMicroSecond() {

        Assert.assertEquals(TimeUtils.toMicroSecond("1"), 1);
        Assert.assertEquals(TimeUtils.toMicroSecond("1s"), 1000);
        Assert.assertEquals(TimeUtils.toMicroSecond("1S"), 1000);
        Assert.assertEquals(TimeUtils.toMicroSecond("1m"), 1000 * 60);
        Assert.assertEquals(TimeUtils.toMicroSecond("1M"), 1000 * 60);
        Assert.assertEquals(TimeUtils.toMicroSecond("1h"), 1000 * 60 * 60);
        Assert.assertEquals(TimeUtils.toMicroSecond("1H"), 1000 * 60 * 60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToMicroSecondException() {

        TimeUtils.toMicroSecond("1a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToMicroSecondException2() {

        TimeUtils.toMicroSecond("");
    }
}