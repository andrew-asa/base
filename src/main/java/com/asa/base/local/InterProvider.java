package com.asa.base.local;

import java.util.Locale;

/**
 * @author andrew_asa
 * @date 2018/10/31.
 * 国际化具体提供类
 */
public interface InterProvider extends LocaleManager {

    /**
     * 获取国际化文本
     *
     * @param key
     * @return
     */
    String getLocaleText(String key);

    /**
     * 获取国际化文本，传入local
     *
     * @param local
     * @param key
     * @return
     */
    String getLocaleText(Locale local, String key);

    /**
     * 获取国际化文本
     *
     * @param key       key值
     * @param parameter 参数
     * @return
     */
    String getLocaleText(String key, String... parameter);

    /**
     * 获取文本
     *
     * @param locale
     * @param key
     * @param parameter
     * @return
     */
    public String getLocaleText(Locale locale, String key, String... parameter);


}
