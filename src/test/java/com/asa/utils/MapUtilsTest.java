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
    public void safeAddToMap2() throws Exception {

        Map<String, String> map = MapUtils.createMap("a", "b");
        MapUtils.safeAddToMap(map, null);
        Assert.assertEquals(map.size(), 1);
        MapUtils.safeAddToMap(map, MapUtils.createMap("b", "c"));
        Assert.assertTrue(MapUtils.containsKey(map, "b"));
    }

    @Test
    public void safeAddToMap() throws Exception {

        Map<String, String> m = null;
        MapUtils.safeAddToMap(m, "d", "vv");
        m = new HashMap<String, String>();
        MapUtils.safeAddToMap(m, "d", "vv");
        MapUtils.safeAddToMap(m, "d", null);
        Assert.assertNull(MapUtils.safeAddToMap(m, null, null));
        String old = MapUtils.safeAddToMap(m, "d", "vb");
        Assert.assertEquals(old, "vv");
    }

    @Test
    public void isEmptyMap() throws Exception {

        Assert.assertTrue(MapUtils.isEmptyMap(null));
        Map<String, String> map = new HashMap<String, String>();
        Assert.assertTrue(MapUtils.isEmptyMap(map));
        Assert.assertFalse(MapUtils.isNotEmptyMap(map));
        map.put("l", "2");
        Assert.assertFalse(MapUtils.isEmptyMap(map));
        Assert.assertTrue(MapUtils.isNotEmptyMap(map));
    }

    @Test
    public void contains() throws Exception {

        Map<String, String> map = new HashMap<String, String>();
        Assert.assertFalse(MapUtils.containsKey(map, "2"));
        Assert.assertFalse(MapUtils.containsKey(null, "2"));
        map.put("l", "2");
        Assert.assertTrue(MapUtils.containsKey(map, "l"));
    }

    @Test
    public void getFirstValue() throws Exception {

        Map<String, String> map = new HashMap<String, String>();
        Assert.assertEquals(MapUtils.getFirstValue(map), null);
        map.put("l", "2");
        Assert.assertEquals(MapUtils.getFirstValue(map), "2");
    }

}