package com.asa.service.properties;

import com.asa.api.PropertiesHandler;

import java.util.Collections;
import java.util.List;

/**
 * @author andrew_asa
 * @date 2019/3/12.
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
    public List<String> getStringList(String key, String regex) {

        if (child.containKey(key)) {
            return child.getStringList(key, regex);
        } else if (father.containKey(key)) {
            return father.getStringList(key, regex);
        }
        return Collections.emptyList();
    }
}
