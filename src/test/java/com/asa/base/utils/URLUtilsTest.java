package com.asa.base.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author andrew_asa
 * @date 2019-09-24.
 */
public class URLUtilsTest {

    @Test
    public void concat() {

        Assert.assertEquals(URLUtils.concat("localhost:8080", "/webroot"), "localhost:8080/webroot");
        Assert.assertEquals(URLUtils.concat("localhost:8080/", "/webroot"), "localhost:8080/webroot");
        Assert.assertEquals(URLUtils.concat("localhost:8080/", "webroot"), "localhost:8080/webroot");
        Assert.assertEquals(URLUtils.concat("localhost:8080", "webroot"), "localhost:8080/webroot");
    }
}