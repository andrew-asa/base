package com.asa.base.service.properties;

import com.asa.base.api.PropertiesHandler;
import com.asa.base.utils.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author andrew_asa
 * @date 2019/3/12.
 */
public class NullPropertiesHandler implements PropertiesHandler {

    @Override
    public boolean containKey(String key) {

        return false;
    }

    @Override
    public long getLong(String key, long defaultValue) {

        return 0;
    }

    @Override
    public int getInt(String key, int defaultValue) {

        return defaultValue;
    }

    @Override
    public double getDouble(String key, double defaultValue) {

        return defaultValue;
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {

        return defaultValue;
    }

    @Override
    public String getValue(String key, String defaultValue) {

        return defaultValue;
    }

    @Override
    public String getValue(String key) {

        return StringUtils.EMPTY;
    }

    @Override
    public List<String> getStringList(String key, String regex) {

        return Collections.emptyList();
    }
}
