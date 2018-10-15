package com.asa.utils;

/**
 * @author andrew_asa
 * @date 2018/10/14.
 */
public class StringUtils {

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
}
