package com.asa.base.utils;

import java.security.InvalidParameterException;

/**
 * @author andrew_asa
 * @date 2019/1/30.
 * 断言帮助类
 */
public class AssertUtils {

    /**
     * @param msg
     * @param exp
     */
    public static void assertNoNull(String msg, String exp) {

        if (exp == null) {
            throw new InvalidParameterException(StringUtils.messageFormat("msg", exp));
        }
    }

    /**
     * @param expected
     * @param actual
     */
    public static void assertNotEquals(long expected, long actual) {

        if (expected == actual) {
            throw new InvalidParameterException(StringUtils.messageFormat("parameter expected:{} actual:{}", expected, actual));
        }
    }


    /**
     * @param errorMsg
     * @param expected
     * @param actual
     */
    public static void assertNotEquals(String errorMsg, long expected, long actual) {

        if (expected == actual) {
            throw new InvalidParameterException(StringUtils.messageFormat(errorMsg, expected, actual));
        }
    }

    /**
     * @param errorMsg
     * @param expected
     * @param actual
     */
    public static void assertNotEquals(String errorMsg, int expected, int actual) {

        if (expected == actual) {
            throw new InvalidParameterException(StringUtils.messageFormat(errorMsg, expected, actual));
        }
    }

    /**
     * @param expected
     * @param actual
     */
    public static void assertNotEquals(int expected, int actual) {

        if (expected == actual) {
            throw new InvalidParameterException(StringUtils.messageFormat("parameter expected:{} actual:{}", expected, actual));
        }
    }
}
