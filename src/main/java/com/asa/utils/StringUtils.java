package com.asa.utils;

import com.asa.log.FormattingTuple;
import com.asa.log.MessageFormatter;

/**
 * @author andrew_asa
 * @date 2018/10/14.
 */
public class StringUtils {

    public static String EMPTY = "";

    /**
     * 克隆
     *
     * @param src
     * @param size
     * @return
     */
    public static String clone(String src, int size) {

        if (src != null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < size; i++) {
                sb.append(src);
            }
            return sb.toString();
        }
        return null;
    }

    public static boolean isEmpty(String str) {

        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {

        return !isEmpty(str);
    }

    public static String messageFormat(String format, Object... args) {

        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(format, args);
        return formattingTuple.getMessage();
    }

    /**
     * double类型转维度
     *
     * @param d A double.
     * @return A String.
     */
    static public String doubleToString(double d) {

        if (Double.isInfinite(d) || Double.isNaN(d)) {
            return "null";
        }
        return dealWithEndZeros(Double.toString(d));
    }

    /**
     * 23.0 -> 23
     *
     * @param s
     * @return
     */
    private static String dealWithEndZeros(String s) {

        if (isDecimal(s)) {
            while (s.endsWith("0")) {
                s = s.substring(0, s.length() - 1);
            }

            if (s.endsWith(".")) {
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    private static boolean isDecimal(String s) {

        return s.indexOf('.') > 0 && s.indexOf('e') < 0 && s.indexOf('E') < 0;
    }
}
