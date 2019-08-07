package com.asa.utils;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author andrew_asa
 * @date 2019/1/30.
 */
public class AssertUtilsTest {

    @Test
    public void assertNoNull() throws Exception {

        //assertNoException(() -> AssertUtils.assertNoNull("", "b"));
        //assertException(() -> AssertUtils.assertNoNull("parameter is null", null));
    }

    @Test
    public void assertNotEquals() throws Exception {

    }

    @Test
    public void assertNotEquals1() throws Exception {

    }

    @Test
    public void assertNotEquals2() throws Exception {

    }

    @Test
    public void assertNotEquals3() throws Exception {

    }

    private void assertException(Function function) {

        try {
            function.apply();
            Assert.assertTrue(false);
        } catch (Throwable throwable) {
            Assert.assertTrue(true);
        }
    }

    private void assertNoException(Function function) {

        try {
            function.apply();
            Assert.assertTrue(true);
        } catch (Throwable throwable) {
            Assert.assertTrue(false);
        }
    }

    public interface Function {

        void apply();
    }
}