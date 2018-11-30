package com.asa.utils;

import java.util.Map;
import java.util.Set;

/**
 * @author andrew_asa
 * @date 2018/10/31.
 */
public class MapUtils {

    /**
     * 是否为空的map null 和 0 元素都代表空map
     *
     * @param map
     * @return
     */
    public static boolean isEmptyMap(Map map) {

        return map == null || map.isEmpty();
    }

    /**
     * 不为空map
     *
     * @param map
     * @return
     */
    public static boolean isNotEmptyMap(Map map) {

        return map != null && !map.isEmpty();
    }

    /**
     * 是否包含某个元素
     *
     * @param map
     * @param key
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> boolean contains(Map<K, V> map, K key) {

        if (map != null) {
            return map.containsKey(key);
        }
        return false;
    }

    /**
     * 获取第一个元素
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> V getFirstValue(Map<K, V> map) {

        if (isNotEmptyMap(map)) {
            Set<K> keys = map.keySet();
            K key = keys.iterator().next();
            if (map.containsKey(key)) {
                return map.get(key);
            }
        }
        return null;
    }

    /**
     * 获取个元素
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> V get(Map<K, V> map, K key) {

        return get(map, key, null);
    }

    /**
     * 获取某个元素，没有则进行返回
     *
     * @param map
     * @param key
     * @param defaultValue
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> V get(Map<K, V> map, K key, V defaultValue) {

        if (isNotEmptyMap(map) && key != null) {
            return map.get(key);
        }
        return defaultValue;
    }

    /**
     * 安全添加到map里面
     *
     * @param map
     * @param key
     * @param value
     * @param <K>
     * @param <V>
     * @return
     * @throws NullPointerException
     */
    public static <K, V> V safeAddToMap(Map<K, V> map, K key, V value) throws NullPointerException {

        if (map != null && key != null && value != null) {
            return map.put(key, value);
        }
        return null;
    }
}
