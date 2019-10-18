package com.asa.utils;

/**
 * @author andrew_asa
 * @date 2019-10-17.
 * 时间类工具类
 */
public class TimeUtils {

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
}
