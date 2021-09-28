package com.asa.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author andrew_asa
 * @date 2021/3/27.
 */
public class MapBuilderTest {

    @Test
    public void custom() {

        MapBuilder<String, String> builder = new MapBuilder();
        Map<String, String> map = builder
                .add("a", "b")
                .add("c", "d")
                .build();
        Assert.assertTrue(map.size()==2);
    }
}