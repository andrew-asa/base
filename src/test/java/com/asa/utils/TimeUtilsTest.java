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


    @Test
    public void isOpenMarketTime() {
        // 2019-12-02 10:43:33
        Assert.assertEquals(TimeUtils.isOpenMarketTime(1575254613000L), true);
        //2019-12-02 14:43:33
        Assert.assertEquals(TimeUtils.isOpenMarketTime(1575269013000L), true);
        //2019-12-02 09:00:33
        Assert.assertEquals(TimeUtils.isOpenMarketTime(1575248433000L), false);
        //2019-12-02 09:30:33
        Assert.assertEquals(TimeUtils.isOpenMarketTime(1575250233000L), true);
        //2019-12-02 11:31:33
        Assert.assertEquals(TimeUtils.isOpenMarketTime(1575257493000L), false);
        //2019-12-02 15:01:33
        Assert.assertEquals(TimeUtils.isOpenMarketTime(1575270093000L), false);
    }

    @Test
    public void getTimeStartOfDay() {
        // 1575270093000L -> 2019-12-02 15:01:33 1575216000000->2019-12-02 00:00:00
        Assert.assertEquals(TimeUtils.getTimeStartOfDay(1575270093000L), 1575216000000L);
        // 1575302399000L -> 2019-12-02 23:59:59 1575216000000->2019-12-02 00:00:00
        Assert.assertEquals(TimeUtils.getTimeStartOfDay(1575302399000L), 1575216000000L);
        // 1575313199000L -> 2019-12-03 2:59:59 1575216000000->2019-12-02 00:00:00
        Assert.assertNotEquals(TimeUtils.getTimeStartOfDay(1575313199000L), 1575216000000L);
    }

    @Test
    public  void getTimeEndOfDay() {

    }
}