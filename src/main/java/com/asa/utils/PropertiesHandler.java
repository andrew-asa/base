package com.asa.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class PropertiesHandler {

    private Properties properties;

    public PropertiesHandler(Properties properties) {

        this.properties = properties;
    }

    /**
     * 或long值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public long getLong(String key, long defaultValue) {

        if (properties.containsKey(key)) {
            String sv = (String) properties.get(key);
            if (StringUtils.isNotEmpty(sv)) {
                return Long.parseLong(sv);
            }
        }
        return defaultValue;
    }

    /**
     * 获取整数类型的值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public int getInt(String key, int defaultValue) {

        if (properties.containsKey(key)) {
            String sv = (String) properties.get(key);
            if (StringUtils.isNotEmpty(sv)) {
                return Integer.parseInt(sv);
            }
        }
        return defaultValue;
    }

    /**
     * 获取double类型的值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public double getDouble(String key, double defaultValue) {

        if (properties.containsKey(key)) {
            String sv = (String) properties.get(key);
            if (StringUtils.isNotEmpty(sv)) {
                return Double.parseDouble(sv);
            }
        }
        return defaultValue;
    }

    /**
     * 获取string类型的数组，以regex分割
     *
     * @param key
     * @param regex
     * @return
     */
    public List<String> getStringList(String key, String regex) {

        List<String> ret = new ArrayList<>();
        if (properties.containsKey(key)) {
            String sv = (String) properties.get(key);
            if (StringUtils.isNotEmpty(sv)) {
                String[] ips = sv.split(regex);
                ret.addAll(ListUtils.arrayToList(ips));
            }
        }
        return ret;
    }
}
