package com.asa.service.properties;

import com.asa.api.PropertiesHandler;
import com.asa.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author andrew_asa
 * @date 2019/3/12.
 * 复合属性文件处理类
 * 第一个碰到的属性类为属性作为基准
 */
public class CompoundPropertiesHandler implements PropertiesHandler {

    private List<PropertiesHandler> handlers = new ArrayList<PropertiesHandler>();

    public CompoundPropertiesHandler(List<PropertiesHandler> handlers) {

        this.handlers = handlers;
    }

    public void addHandler(PropertiesHandler handler) {

        if (handler != null) {
            handlers.add(handler);
        }
    }

    @Override
    public boolean containKey(String key) {

        for (PropertiesHandler handler : handlers) {
            if (handler.containKey(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long getLong(String key, long defaultValue) {

        for (PropertiesHandler handler : handlers) {
            if (handler.containKey(key)) {
                return handler.getLong(key, defaultValue);
            }
        }
        return defaultValue;
    }

    @Override
    public int getInt(String key, int defaultValue) {

        for (PropertiesHandler handler : handlers) {
            if (handler.containKey(key)) {
                return handler.getInt(key, defaultValue);
            }
        }
        return defaultValue;
    }

    @Override
    public double getDouble(String key, double defaultValue) {

        for (PropertiesHandler handler : handlers) {
            if (handler.containKey(key)) {
                return handler.getDouble(key, defaultValue);
            }
        }
        return defaultValue;
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {

        for (PropertiesHandler handler : handlers) {
            if (handler.containKey(key)) {
                return handler.getBoolean(key, defaultValue);
            }
        }
        return defaultValue;
    }

    @Override
    public String getValue(String key, String defaultValue) {

        for (PropertiesHandler handler : handlers) {
            if (handler.containKey(key)) {
                return handler.getValue(key, defaultValue);
            }
        }
        return defaultValue;
    }

    @Override
    public String getValue(String key) {

        for (PropertiesHandler handler : handlers) {
            if (handler.containKey(key)) {
                return handler.getValue(key);
            }
        }
        return StringUtils.EMPTY;
    }

    @Override
    public List<String> getStringList(String key, String regex) {

        for (PropertiesHandler handler : handlers) {
            if (handler.containKey(key)) {
                return handler.getStringList(key, regex);
            }
        }
        return Collections.emptyList();
    }
}
