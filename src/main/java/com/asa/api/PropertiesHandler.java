package com.asa.api;

import java.util.List;

/**
 * @author andrew_asa
 * @date 2019/3/12.
 */
public interface PropertiesHandler {

    /**
     * 是否包含该key值
     *
     * @param key
     * @return
     */
    boolean containKey(String key);

    /**
     * 或long值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    long getLong(String key, long defaultValue);

    /**
     * 获取整数类型的值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    int getInt(String key, int defaultValue);

    /**
     * 获取double类型的值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    double getDouble(String key, double defaultValue);

    /**
     * 获取boolean 值
     * @param key
     * @param defaultValue
     * @return
     */
    boolean getBoolean(String key, boolean defaultValue);

    /**
     * 获取字符串值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    String getValue(String key, String defaultValue);

    /**
     * 获取字符串值，没有就返回""
     *
     * @param key
     * @return
     */
    String getValue(String key);

    /**
     * 获取string类型的数组，以regex分割
     *
     * @param key
     * @param regex
     * @return
     */
    List<String> getStringList(String key, String regex);
}
