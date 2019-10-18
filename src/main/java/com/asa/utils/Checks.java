package com.asa.utils;


import java.security.InvalidParameterException;
import java.util.Iterator;

/**
 * @author andrew_asa
 * @date 2019-10-15.
 */
public class Checks {

    /**
     * 非空判断
     *
     * @param msg
     * @param element
     */
    public static void notNull(String msg, Object element) {

        if (element == null) {
            throw new InvalidParameterException(StringUtils.messageFormat("element {} is null", msg));
        }
    }

    /**
     * 非零判断
     *
     * @param parameter
     * @param value
     */
    public static void nonZero(String parameter, int value) {

        if (value == 0) {
            throw new InvalidParameterException(StringUtils.messageFormat(" {} is zero", parameter));
        }
    }

    /**
     * 非负判断
     *
     * @param parameter
     * @param value
     */
    public static void nonNegative(String parameter, int value) {

        if (value < 0) {
            throw new InvalidParameterException(StringUtils.messageFormat(" {} is negative", parameter));
        }
    }

    /**
     * 非负判断
     *
     * @param parameter
     * @param value
     */
    public static void nonNegative(String parameter, long value) {

        if (value < 0) {
            throw new InvalidParameterException(StringUtils.messageFormat(" {} is negative", parameter));
        }
    }

    /**
     * 非负判断
     *
     * @param parameter
     * @param value
     */
    public static void nonNegative(String parameter, double value) {

        if (value < 0) {
            throw new InvalidParameterException(StringUtils.messageFormat(" {} is negative", parameter));
        }
    }

    /**
     * 非空或者没有元素
     *
     * @param msg
     * @param iter
     * @param <T>
     */
    public static <T> void notEmptyOrNull(String msg, Iterator<T> iter) {

        if (iter == null || !iter.hasNext()) {
            throw new InvalidParameterException(StringUtils.messageFormat(" {} is empty or null", msg));
        }
    }

    /**
     * 非空或者没有元素
     *
     * @param msg
     * @param iter
     * @param <T>
     */
    public static <T> void notEmptyOrNull(String msg, T[] iter) {

        if (iter == null || iter.length == 0) {
            throw new InvalidParameterException(StringUtils.messageFormat(" {} is empty or null", msg));
        }
    }
}
