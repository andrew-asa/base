package com.asa.local;

import com.asa.utils.MapUtils;
import com.asa.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author andrew_asa
 * @date 2018/10/31.
 */
public class LocalBundle {

    private Map<Locale, ResourceBundle> bundleMap = new HashMap<>();

    private LocaleMarker localeMarker;

    public LocalBundle(LocaleMarker localeMarker) {

        this.localeMarker = localeMarker;
        init();
    }

    private void init() {

        List<Locale> locales = InterProviderFactory.getSupportLocale();
        String path = localeMarker.getPath();
        for (Locale locale : locales) {
            ResourceBundle bundle = ResourceBundle.getBundle(path, locale);
            bundleMap.put(locale, bundle);
        }
    }

    public Map<Locale, ResourceBundle> getBundleMap() {

        return bundleMap;
    }

    public void setBundleMap(Map<Locale, ResourceBundle> bundleMap) {

        this.bundleMap = bundleMap;
    }

    public LocaleMarker getLocaleMarker() {

        return localeMarker;
    }

    public void setLocaleMarker(LocaleMarker localeMarker) {

        this.localeMarker = localeMarker;
    }

    public ResourceBundle getBundle(Locale locale) {

        return MapUtils.get(bundleMap, locale);
    }
}
