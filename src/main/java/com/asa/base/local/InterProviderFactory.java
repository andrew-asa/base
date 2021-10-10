package com.asa.base.local;

import com.asa.base.utils.ListUtils;
import com.asa.base.local.impl.InterProviderImpl;

import java.util.List;
import java.util.Locale;

/**
 * @author andrew_asa
 * @date 2018/10/31.
 * 国际化提供工厂
 */
public class InterProviderFactory {

    private static InterProvider provider;

    public static List<Locale> supportLocale = ListUtils.arrayToList(Locale.SIMPLIFIED_CHINESE, Locale.US);

    public static List<Locale> getSupportLocale() {

        return supportLocale;
    }

    public synchronized static InterProvider getProvider() {

        if (provider == null) {
            provider = new InterProviderImpl();
        }
        return provider;
    }

    public static void registerProvider(InterProvider provider) {

        if (provider != null) {
            InterProviderFactory.provider = provider;
        }
    }

    /**
     * 注册国际化文件
     *
     * @param marker
     */
    public static void registerLocale(LocaleMarker marker) {

        InterProvider provider = getProvider();
        provider.addResource(marker);
    }
}
