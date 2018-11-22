package com.asa.log;

/**
 * @author andrew_asa
 * @date 2018/11/22.
 */
public class LoggerFactory {

    private static LoggerProvider provider = new SystemOutLoggerProvider();

    public static LoggerProvider getLogger() {

        return provider;
    }

    public static LoggerProvider getProvider() {

        return provider;
    }

    public static void setProvider(LoggerProvider provider) {

        LoggerFactory.provider = provider;
    }
}
