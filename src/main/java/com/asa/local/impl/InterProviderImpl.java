package com.asa.local.impl;

import com.asa.local.InterProvider;
import com.asa.local.LocalBundle;
import com.asa.local.LocaleMarker;
import com.asa.log.FormattingTuple;
import com.asa.log.MessageFormatter;
import com.asa.utils.ComparatorUtils;
import com.asa.utils.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author andrew_asa
 * @date 2018/10/31.
 */
public class InterProviderImpl implements InterProvider {

    private List<LocalBundle> bundles = new ArrayList<LocalBundle>();


    public InterProviderImpl() {

    }


    @Override
    public String getLocaleText(String key) {

        return getLocaleText(Locale.getDefault(), key);
    }

    @Override
    public String getLocaleText(Locale locale, String key, String... parameter) {

        String value = this.getLocaleText(locale, key);
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(value, parameter);
        return formattingTuple.getMessage();
    }

    @Override
    public String getLocaleText(Locale local, String key) {

        for (LocalBundle item : bundles) {
            ResourceBundle bundle = item.getBundle(local);
            if (bundle.containsKey(key)) {
                String value = bundle.getString(key);
                if (StringUtils.isNotEmpty(value)) {
                    try {
                        return new String(value.getBytes("ISO-8859-1"), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        return value;
                    }
                }
            }
        }
        return key;
    }

    @Override
    public String getLocaleText(String key, String... parameter) {

        return getLocaleText(Locale.getDefault(), key, parameter);
    }

    @Override
    public void addResource(LocaleMarker marker) {

        LocalBundle bundle = new LocalBundle(marker);
        bundles.add(bundle);
    }

    @Override
    public void removeResource(LocaleMarker marker) {

        List<LocalBundle> tbundles = new ArrayList<LocalBundle>();
        for (LocalBundle localBundle : bundles) {
            if (!ComparatorUtils.equals(marker, localBundle.getLocaleMarker())) {
                tbundles.add(localBundle);
            }
        }
        bundles = tbundles;
    }
}
