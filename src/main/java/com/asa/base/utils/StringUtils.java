package com.asa.base.utils;

import com.asa.base.log.FormattingTuple;
import com.asa.base.log.MessageFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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

    /**
     * 字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {

        return str == null || str.length() == 0;
    }

    /**
     * 如果为空则返回替代字符串
     *
     * @param str
     * @param rep
     * @return
     */
    public static String ifEmpty(String str, String rep) {

        if (isEmpty(str)) {
            return rep;
        } else {
            return str;
        }
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
     * str1是否包含str2
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean contains(String str1, String str2) {

        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.contains(str2);
    }

    /**
     * str
     * @param str 是否包含strs中的某一项
     * @param strs
     * @return
     */
    public static boolean containsItem(String str, List<String> strs) {

        if (str == null || strs == null) {
            return false;
        }
        for (String s : strs) {
            if (contains(str, s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * str1是否已str2结尾
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean endWith(String str1, String str2) {

        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.endsWith(str2);
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

        if (str == null && prefix == null) {
            return true;
        }
        if (str == null || prefix == null) {
            return false;
        }
        return str.startsWith(prefix);
    }

    /**
     * 字符串是否以prefixs里面的某一项开头
     *
     * @param str
     * @param prefixs
     * @return
     */
    public static boolean startsWithListItem(String str, List<String> prefixs) {

        if (ListUtils.isEmpty(prefixs)) {
            return false;
        }
        for (String s : prefixs) {
            if (startsWith(str, s)) {
                return true;
            }
        }
        return false;
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

    /**
     * 替换第一个匹配模式
     * @param inString
     * @param oldPattern
     * @param newPattern
     * @return
     */
    public static String replaceFirst(String inString, String oldPattern, String newPattern) {

        if (inString == null || oldPattern == null || newPattern == null) {
            return inString;
        }
        return inString.replaceFirst(oldPattern, newPattern);
    }


    public static String replace(String inString, String oldPattern, String newPattern) {

        if (StringUtils.isEmpty(inString) || StringUtils.isEmpty(oldPattern) || newPattern == null) {
            return inString;
        }
        int index = inString.indexOf(oldPattern);
        if (index == -1) {
            // no occurrence -> can return input as-is
            return inString;
        }

        int capacity = inString.length();
        if (newPattern.length() > oldPattern.length()) {
            capacity += 16;
        }
        StringBuilder sb = new StringBuilder(capacity);

        int pos = 0;  // our position in the old string
        int patLen = oldPattern.length();
        while (index >= 0) {
            sb.append(inString.substring(pos, index));
            sb.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }

        // append any characters to the right of a match
        sb.append(inString.substring(pos));
        return sb.toString();
    }

    public static String[] delimitedListToStringArray(String str, String delimiter) {

        return delimitedListToStringArray(str, delimiter, null);
    }

    public static String[] delimitedListToStringArray(
            String str, String delimiter, String charsToDelete) {

        if (str == null) {
            return new String[0];
        }
        if (delimiter == null) {
            return new String[]{str};
        }

        List<String> result = new ArrayList<>();
        if (delimiter.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
            }
        } else {
            int pos = 0;
            int delPos;
            while ((delPos = str.indexOf(delimiter, pos)) != -1) {
                result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
                pos = delPos + delimiter.length();
            }
            if (str.length() > 0 && pos <= str.length()) {
                // Add rest of String, but not in case of empty input.
                result.add(deleteAny(str.substring(pos), charsToDelete));
            }
        }
        return toStringArray(result);
    }

    public static String delete(String inString, String pattern) {

        return replace(inString, pattern, "");
    }


    public static String deleteAny(String inString, String charsToDelete) {

        if (StringUtils.isEmpty(inString) || StringUtils.isEmpty(charsToDelete)) {
            return inString;
        }

        StringBuilder sb = new StringBuilder(inString.length());
        for (int i = 0; i < inString.length(); i++) {
            char c = inString.charAt(i);
            if (charsToDelete.indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static String[] toStringArray(Collection<String> collection) {

        return collection.toArray(new String[0]);
    }

    public static String collectionToDelimitedString(
            Collection<?> coll, String delim, String prefix, String suffix) {

        if (CollectionUtils.isEmpty(coll)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Iterator<?> it = coll.iterator();
        while (it.hasNext()) {
            sb.append(prefix).append(it.next()).append(suffix);
            if (it.hasNext()) {
                sb.append(delim);
            }
        }
        return sb.toString();
    }


    public static String collectionToDelimitedString(Collection<?> coll, String delim) {

        return collectionToDelimitedString(coll, delim, "", "");
    }


    public static String collectionToCommaDelimitedString(Collection<?> coll) {

        return collectionToDelimitedString(coll, ",");
    }
}
