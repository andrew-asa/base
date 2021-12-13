package com.asa.base.utils.math;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author andrew_asa
 * @date 2021/11/13.
 */
public class NumberUtilsTest extends TestCase {

    @Test
    public void testIsDigits() {
        assertFalse(NumberUtils.isDigits(null));
        assertFalse("isDigits('') failed",NumberUtils.isDigits(""));
        assertTrue("isDigits(String) failed",NumberUtils.isDigits("12345"));
        assertFalse("isDigits(String) neg 1 failed",NumberUtils.isDigits("1234.5"));
        assertFalse("isDigits(String) neg 3 failed",NumberUtils.isDigits("1ab"));
        assertFalse("isDigits(String) neg 4 failed",NumberUtils.isDigits("abc"));
        assertFalse("带正负符号",NumberUtils.isDigits("+4"));
        assertFalse("带正负符号",NumberUtils.isDigits("-4"));
    }
}