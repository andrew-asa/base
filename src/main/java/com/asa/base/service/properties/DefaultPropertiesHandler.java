package com.asa.base.service.properties;

import com.asa.base.api.PropertiesHandler;
import com.asa.base.utils.BooleanUtils;
import com.asa.base.utils.ListUtils;
import com.asa.base.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class DefaultPropertiesHandler implements PropertiesHandler {

    private Properties properties;

    public DefaultPropertiesHandler(Properties properties) {

        this.properties = properties;
    }

    @Override
    public boolean containKey(String key) {

        return properties.containsKey(key);
    }

    /**
     * 或long值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    @Override
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
    @Override
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
    @Override
    public double getDouble(String key, double defaultValue) {

        if (properties.containsKey(key)) {
            String sv = (String) properties.get(key);
            if (StringUtils.isNotEmpty(sv)) {
                return Double.parseDouble(sv);
            }
        }
        return defaultValue;
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {

        if (properties.containsKey(key)) {
            String sv = (String) properties.get(key);
            if (StringUtils.isNotEmpty(sv)) {
                return BooleanUtils.toBoolean(sv);
            }
        }
        return defaultValue;
    }

    @Override
    public String getValue(String key, String defaultValue) {

        if (properties.containsKey(key)) {
            String sv = (String) properties.get(key);
            return sv;
        }
        return defaultValue;
    }

    @Override
    public String getValue(String key) {

        return getValue(key, StringUtils.EMPTY);
    }

    /**
     * 获取string类型的数组，以regex分割
     *
     * @param key
     * @param regex
     * @return
     */
    @Override
    public List<String> getStringList(String key, String regex) {

        List<String> ret = new ArrayList<String>();
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
