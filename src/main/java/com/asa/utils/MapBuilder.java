package com.asa.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author andrew_asa
 * @date 2021/3/27.
 */
public class MapBuilder<K,V> {

    private Map<K,V> map;

    public MapBuilder() {

        map = new HashMap<>();
    }
    public MapBuilder(Map<K,V> map) {
        this.map = map;
    }
    public  static  MapBuilder custom() {
        MapBuilder ret = new MapBuilder(new HashMap());
        return ret;
    }

    public Map<K, V> build() {
        return map;
    }

    public MapBuilder add(K key, V value) {
        MapUtils.safeAddToMap(map,key,value);
        return this;
    }

}
