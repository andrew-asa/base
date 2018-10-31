package com.asa.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @author andrew_asa
 * @date 2018/10/31.
 */
public class MapUtilsTest {

    @Test
    public void isEmptyMap() throws Exception {

        Assert.assertTrue(MapUtils.isEmptyMap(null));
        Map<String, String> map = new HashMap<>();
        Assert.assertTrue(MapUtils.isEmptyMap(map));
        Assert.assertFalse(MapUtils.isNotEmptyMap(map));
        map.put("l", "2");
        Assert.assertFalse(MapUtils.isEmptyMap(map));
        Assert.assertTrue(MapUtils.isNotEmptyMap(map));
    }

    @Test
    public void contains() throws Exception {

        Map<String, String> map = new HashMap<>();
        Assert.assertFalse(MapUtils.contains(map, "2"));
        Assert.assertFalse(MapUtils.contains(null, "2"));
        map.put("l", "2");
        Assert.assertTrue(MapUtils.contains(map, "l"));
    }

    @Test
    public void getFirstValue() throws Exception {

        Map<String, String> map = new HashMap<>();
        Assert.assertEquals(MapUtils.getFirstValue(map), null);
        map.put("l", "2");
        Assert.assertEquals(MapUtils.getFirstValue(map), "2");
    }

}