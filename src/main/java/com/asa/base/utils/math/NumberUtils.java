package com.asa.base.utils.math;

import com.asa.base.utils.StringUtils;
/**
 * @author andrew_asa
 * @date 2021/11/13.
 */
public class NumberUtils {

    /**
     * 是否为数字，详见StringUtils.isNumeric()
     * @param str
     * @return
     */
    public static boolean isDigits(final String str) {
        return StringUtils.isNumeric(str);
    }
}
