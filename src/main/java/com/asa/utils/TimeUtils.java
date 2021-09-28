package com.asa.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author andrew_asa
 * @date 2019-10-17.
 * 时间类工具类
 */
public class TimeUtils {

    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";


    public static SimpleDateFormat YMD_FORMAT = new SimpleDateFormat(FORMAT_SHORT);

    /**
     * 英文全称  如：2010-12-01 23:15:06
     */
    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 中文简写  如：2010年12月01日
     */
    public static String FORMAT_SHORT_CN = "yyyy年MM月dd";

    /**
     * 中文全称  如：2010年12月01日  23时15分06秒
     */
    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    public static final String DEFAULT = "Default";
    public static final String DATE_FORMAT1 = "yyyy-MM-dd";
    public static final String DATE_FORMAT2 = "yyyy-MM";
    public static final String DATE_FORMAT3 = "yyyy-MM-dd HH";
    public static final String DATE_FORMAT4 = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT5 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT6 = "MM-dd";


    /**
     * 相差多少s
     *
     * @param start 单位ms
     * @param end   单位ms
     * @return
     */
    public static double timeCostAsSecond(long start, long end) {

        return timeCostAsMicroSecond(start, end) / 1000;
    }

    /**
     * 相差多少毫秒
     *
     * @param start
     * @param end
     * @return
     */
    public static long timeCostAsMicroSecond(long start, long end) {

        return (end - start);
    }

    /**
     * 到现在为止耗费了多长时间
     *
     * @param start
     * @return
     */
    public static long timeCostAsMicroSecond(long start) {

        return timeCostAsMicroSecond(start, System.currentTimeMillis());
    }

    /**
     * 10s ,10min 1000,转
     *
     * @param ts
     * @return
     */
    public static long toMicroSecond(String ts) {

        long time = 1;
        long base = 0;
        if (StringUtils.isNotEmpty(ts)) {
            // 数值
            String bs = getNumber(ts);
            if (StringUtils.isNotEmpty(bs)) {
                // 单位
                String us = ts.substring(bs.length());
                base = Long.parseLong(bs);
                if (StringUtils.isNotEmpty(us)) {
                    if (StringUtils.equalsIgnoreCase(us, "s")) {
                        time = 1000;
                    } else if (StringUtils.equalsIgnoreCase(us, "m")) {
                        time = 1000 * 60;
                    } else if (StringUtils.equalsIgnoreCase(us, "h")) {
                        time = 1000 * 60 * 60;
                    } else {
                        throw new IllegalArgumentException(StringUtils.messageFormat("error '{}' time str", ts));
                    }
                }
                return base * time;
            }
        }
        throw new IllegalArgumentException(StringUtils.messageFormat("error '{}' time str", ts));
    }

    private static String getNumber(String regular) {

        int index = 0;
        for (int i = 0; i < regular.length(); i++) {
            char c = regular.charAt(i);
            if (Character.isDigit(c)) {
                if (i == regular.length() - 1) {
                    index = i + 1;
                } else {
                    index = i;
                }
                continue;
            } else {
                index = i;
                break;
            }
        }
        return regular.substring(0, index);
    }

    private static boolean isNumeric(String str) {

        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 获取时间戳
     */
    public static String getTimeString() {

        SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }



    /**
     * 获取周几
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(long date) {

        return getDayOfWeek(new Date(date));
    }

    /**
     * 获取周几
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }


    /**
     * 功能描述：返回月
     *
     * @param date Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日
     *
     * @param date Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getDay(long date) {

        return getDay(new Date(date));
    }

    /**
     * 功能描述：返回小
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getHour(long date) {

        return getHour(new Date(date));
    }

    /**
     * 功能描述：返回分
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    public static int getMinute(long date) {

        return getMinute(new Date(date));
    }

    /**
     * 返回秒钟
     *
     * @param date Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫
     *
     * @param date 日期
     * @return 返回毫
     */
    public static long getMillis(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    public static long getMillis(long date) {

        return getMillis(new Date(date));
    }

    public static boolean isOpenMarketTime(long time) {

        long current = time;
        int hour = TimeUtils.getHour(current);
        int minute = TimeUtils.getMinute(current);
        if (hour == 9) {
            return minute >= 30;
        }
        if (hour == 11) {
            return minute <= 30;
        }
        return hour > 9 && hour < 15;
    }

    /**
     * 一天的开始时间
     *
     * @param time
     * @return
     */
    public static long getTimeStartOfDay(long time) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dayStart = calendar.getTime();
        return dayStart.getTime();
    }


    /**
     * 一天的开始时间
     *
     * @param time
     * @return
     */
    public static long getTimeEndOfDay(long time) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date dayEnd = calendar.getTime();
        return dayEnd.getTime();
    }

    /**
     * 是否是周末
     *
     * @param time
     * @return
     */
    public static boolean isWeekend(long time) {

        int dayOfWeek = getDayOfWeek(time);
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    public static Timestamp parseYmdTimestamp(String string) throws ParseException {

        Date date = YMD_FORMAT.parse(string);
        return new Timestamp(date.getTime());
    }

    private static ThreadLocal<Map<String, SimpleDateFormat>> dateFormatThreadLocal = new ThreadLocal();

    public static String formatDateToString(String format, Date date) {
        return getDateFormatFromString(format).format(date);
    }

    private static DateFormat getDateFormatFromString(String format) {
        initDateFormatMap();
        Map map = (Map)dateFormatThreadLocal.get();
        SimpleDateFormat dateFormat = (SimpleDateFormat)map.get(format);
        if (dateFormat != null) {
            return dateFormat;
        } else {
            SimpleDateFormat defaultFormat = (SimpleDateFormat)map.get("DEFAULT");
            if (StringUtils.equals(defaultFormat.toPattern(), format)) {
                return defaultFormat;
            } else {
                defaultFormat.applyPattern(format);
                return defaultFormat;
            }
        }
    }

    private static void initDateFormatMap() {
        if (dateFormatThreadLocal.get() == null) {
            ConcurrentHashMap map = new ConcurrentHashMap();
            map.put("Default", new SimpleDateFormat());
            map.put("yyyy-MM-dd", new SimpleDateFormat("yyyy-MM-dd"));
            map.put("yyyy-MM", new SimpleDateFormat("yyyy-MM"));
            map.put("yyyy-MM-dd HH", new SimpleDateFormat("yyyy-MM-dd HH"));
            map.put("yyyy-MM-dd HH:mm", new SimpleDateFormat("yyyy-MM-dd HH:mm"));
            map.put("yyyy-MM-dd HH:mm:ss", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            map.put("MM-dd", new SimpleDateFormat("MM-dd"));
            dateFormatThreadLocal.set(map);
        }

    }

}
