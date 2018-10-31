package com.asa.local;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;


/**
 * @author andrew_asa
 * @date 2018/10/31.
 */
public class InterProviderFactoryTest {

    @Test
    public void registerLocale() throws Exception {

        InterProviderFactory.registerLocale(LocaleMarker.create("com/asa/local/test"));
        InterProviderFactory.registerLocale(LocaleMarker.create("com/asa/local/test2"));
        String china = InterProviderFactory.getProvider().getLocaleText(Locale.SIMPLIFIED_CHINESE, "BASE-Test_Test");
        String china2 = InterProviderFactory.getProvider().getLocaleText(Locale.SIMPLIFIED_CHINESE, "BASE-Test2_Test");
        String en = InterProviderFactory.getProvider().getLocaleText(Locale.US, "BASE-Test_Test");
        String en2 = InterProviderFactory.getProvider().getLocaleText(Locale.US, "BASE-Test2_Test");
        Assert.assertEquals(china, "测试");
        Assert.assertEquals(china2, "测试2");
        Assert.assertEquals(en, "test");
        Assert.assertEquals(en2, "test2");
    }

    @Test
    public void getProvider() throws Exception {

        InterProviderFactory.registerLocale(LocaleMarker.create("com/asa/local/test"));
        String china = InterProviderFactory.getProvider().getLocaleText(Locale.SIMPLIFIED_CHINESE, "BASE-Test_Test");
        String china2 = InterProviderFactory.getProvider().getLocaleText(Locale.SIMPLIFIED_CHINESE, "BASE-Test_Test2", "不连接");
        String en = InterProviderFactory.getProvider().getLocaleText(Locale.US, "BASE-Test_Test");
        String en2 = InterProviderFactory.getProvider().getLocaleText(Locale.US, "BASE-Test_Test2", "ddd");
        Assert.assertEquals(china, "测试");
        Assert.assertEquals(china2, "测试不连接连接");
        Assert.assertEquals(en, "test");
        Assert.assertEquals(en2, "testdddnoconnect");
    }

}