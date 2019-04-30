package com.asa.utils;

import com.asa.log.FormattingTuple;
import com.asa.log.MessageFormatter;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author andrew_asa
 * @date 2018/10/14.
 * 处理输出为string | 输入为string的相关工具类
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

    public static boolean equalsIgnoreCase(String str1, String str2) {

        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equalsIgnoreCase(str2);
    }

    public static boolean equals(String str1, String str2) {

        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equals(str2);
    }

    /**
     * 忽略大小写，是否包含
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean containsIgnoreCase(String str1, String str2) {

        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        String t1 = str1.toLowerCase();
        String t2 = str2.toLowerCase();
        return t1.contains(t2);
    }

    /**
     * 字符串长度
     *
     * @param string
     * @return
     */
    public static int length(String string) {

        if (isEmpty(string)) {
            return 0;
        }
        return string.length();
    }

    /**
     * 是否是以prefix作为前缀
     *
     * @param str
     * @param prefix
     * @return
     */
    public static boolean startsWith(String str, String prefix) {

        if (str == null || prefix == null) {
            return false;
        }
        return str.startsWith(prefix);
    }

    /**
     * 将一个集合中的元素按照给定的连接符连接成一个字符串
     *
     * @param c  集合
     * @param se 连接符
     * @return 连接后的字符串
     */
    public static String join(Collection c, String se) {

        if (c != null && c.size() > 0) {
            if (se == null) {
                se = StringUtils.EMPTY;
            }
            StringBuffer sb = new StringBuffer();
            java.util.Iterator it = c.iterator();
            while (it.hasNext()) {
                Object o = it.next();
                sb.append(o);
                if (it.hasNext()) {
                    sb.append(se);
                }
            }
            return sb.toString();
        } else {
            return StringUtils.EMPTY;
        }
    }

    /**
     * 将一个数组中的元素按照给定的连接符连接成一个字符串
     *
     * @param array 数组
     * @param se    连接符
     * @return 连接后的字符串
     */
    public static String join(Object[] array, String se) {

        return join(Arrays.asList(array), se);
    }

    /**
     * 将一个数组中的元素用空字符连接成一个字符串
     *
     * @param array 数组
     * @return 连接后的字符串
     */
    public static String join(Object[] array) {

        return join(array, StringUtils.EMPTY);
    }

    /**
     * 将一个集合中的元素用空字符连接成一个字符串
     *
     * @param c 集合
     * @return 连接后的字符串
     */
    public static String join(Collection c) {

        return join(c, StringUtils.EMPTY);
    }

    /**
     * 分割
     *
     * @param str
     * @param sp
     * @return
     */
    public static String[] split(String str, String sp) {

        if (isNotEmpty(str)) {
            return str.split(sp);
        }
        return new String[0];
    }

    /**
     * 以空格分割
     *
     * @param str
     * @return
     */
    public static String[] splitWithBlank(String str) {

        return split(str, "\\s+");
    }

    /**
     * 空格分割并安全的进行获取第index个原始，如果没有则返回默认值
     *
     * @param str
     * @param index
     * @param defaultValue
     * @return
     */
    public static String splitWithBlankAndSafeGetItem(String str, int index, String defaultValue) {

        String[] items = splitWithBlank(str);
        if (items.length > index) {
            return items[index];
        }
        return defaultValue;
    }

    public static String[] splitWithBlankAndSafeGetItem(String str, String defaultValue, int... inx) {

        String[] items = splitWithBlank(str);
        String[] ret = new String[inx.length];
        for (int i = 0; i < inx.length; i++) {
            int index = inx[i];
            if (items.length > index) {
                ret[i] = items[index];
            } else {
                ret[i] = defaultValue;
            }
        }
        return ret;
    }
}
