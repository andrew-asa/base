package com.asa.log;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author andrew_asa
 * @date 2018/11/22.
 */
public class LoggerFactory {

    private static LoggerProvider DEFAULT = new ConsoleLoggerProvider("default");
    private static LoggerProviderFactory DEBUG_FACTORY = new ConsoleLoggerProviderFactory();
    private static ConcurrentMap<String, LoggerProvider> log4jLoggers = new ConcurrentHashMap();


    public static LoggerProvider getLogger() {

        return DEFAULT;
    }

    public static LoggerProvider getLogger(Class cls) {
        String name = cls.getName();
        LoggerProvider instance = (LoggerProvider)log4jLoggers.get(cls.getName());
        if (instance != null) {
            return instance;
        } else {
            LoggerProvider newInstance = DEBUG_FACTORY.createLoggerProvider(name);
            LoggerProvider oldInstance = (LoggerProvider)log4jLoggers.putIfAbsent(name, newInstance);
            return oldInstance == null ? newInstance : oldInstance;
        }
    }

    public static LoggerProvider getProvider() {

        return DEFAULT;
    }

    public static void setProvider(LoggerProvider provider) {

        LoggerFactory.DEFAULT = provider;
    }

    public static LoggerProviderFactory getDebugFactory() {

        return DEBUG_FACTORY;
    }

    public static void setDebugFactory(LoggerProviderFactory debugFactory) {

        DEBUG_FACTORY = debugFactory;
    }
}
