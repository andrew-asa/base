package com.asa.base.utils;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    public void getTimeEndOfDay() {

    }

    @Test
    public void testDayOfWeek() {

        Assert.assertEquals(TimeUtils.getDayOfWeek(1576224653000L), Calendar.FRIDAY);
        Assert.assertEquals(TimeUtils.getDayOfWeek(1576311053000L), Calendar.SATURDAY);
        Assert.assertEquals(TimeUtils.getDayOfWeek(1576397453000L), Calendar.SUNDAY);
    }

    @Test
    public void testIsWeekend() {

        Assert.assertFalse(TimeUtils.isWeekend(1576224653000L));
        Assert.assertTrue(TimeUtils.isWeekend(1576311053000L));
        Assert.assertTrue(TimeUtils.isWeekend(1576397453000L));
    }

    @Test
    public void timeCostAsSecond() {

    }

    @Test
    public void timeCostAsMicroSecond() {

    }

    @Test
    public void timeCostAsMicroSecond1() {

    }

    @Test
    public void toMicroSecond() {

    }

    @Test
    public void getTimeString() {

    }

    @Test
    public void getDayOfWeek() {

    }

    @Test
    public void getDayOfWeek1() {

    }

    @Test
    public void getMonth() {

    }

    @Test
    public void getDay() {

    }

    @Test
    public void getDay1() {

    }

    @Test
    public void parseYmdTimestamp() throws ParseException {

        Timestamp timestamp = TimeUtils.parseYmdTimestamp("2019-09-30");
        Assert.assertEquals(timestamp.getTime(), 1569772800000L);
    }

    @Test
    public void formatDateToString() {

        Date date = new Date();
        date.setTime(1616858774L*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        sdf.format(1616858774L);
        System.out.println(sdf.format(1616858774L));
    }
}