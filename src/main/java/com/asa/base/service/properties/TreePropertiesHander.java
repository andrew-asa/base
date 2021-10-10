package com.asa.base.service.properties;

import com.asa.base.api.PropertiesHandler;
import com.asa.base.utils.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author andrew_asa
 * @date 2019/3/12.
 * 已第一个排查到的child存在的属性作为基准属性
 */
public class TreePropertiesHander implements PropertiesHandler {

    private PropertiesHandler father;

    private PropertiesHandler child;

    public TreePropertiesHander(PropertiesHandler father, List<PropertiesHandler> childs) {

        this.father = father;
        this.child = new CompoundPropertiesHandler(childs);
    }

    @Override
    public boolean containKey(String key) {

        return child.containKey(key) || father.containKey(key);
    }

    @Override
    public long getLong(String key, long defaultValue) {

        if (child.containKey(key)) {
            return child.getLong(key, defaultValue);
        } else if (father.containKey(key)) {
            return father.getLong(key, defaultValue);
        }
        return defaultValue;
    }

    @Override
    public int getInt(String key, int defaultValue) {

        if (child.containKey(key)) {
            return child.getInt(key, defaultValue);
        } else if (father.containKey(key)) {
            return father.getInt(key, defaultValue);
        }
        return defaultValue;
    }

    @Override
    public double getDouble(String key, double defaultValue) {

        if (child.containKey(key)) {
            return child.getDouble(key, defaultValue);
        } else if (father.containKey(key)) {
            return father.getDouble(key, defaultValue);
        }
        return defaultValue;
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {


        if (child.containKey(key)) {
            return child.getBoolean(key, defaultValue);
        } else if (father.containKey(key)) {
            return father.getBoolean(key, defaultValue);
        }
        return defaultValue;
    }

    @Override
    public String getValue(String key, String defaultValue) {

        if (child.containKey(key)) {
            return child.getValue(key, defaultValue);
        } else if (father.containKey(key)) {
            return father.getValue(key, defaultValue);
        }
        return defaultValue;
    }

    @Override
    public String getValue(String key) {

        return getValue(key, StringUtils.EMPTY);
    }

    @Override
    public List<String> getStringList(String key, String regex) {

        if (child.containKey(key)) {
            return child.getStringList(key, regex);
        } else if (father.containKey(key)) {
            return father.getStringList(key, regex);
        }
        return Collections.emptyList();
    }
}
