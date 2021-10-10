package com.asa.base.log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author andrew_asa
 * @date 2018/11/22.
 */
public class LoggerFactory {

    private static LoggerProvider DEFAULT = new ConsoleLoggerProvider("default");

    private static LoggerProvider NULL_LOGGER = new NullLoggerProvider();

    private static LoggerProviderFactory DEBUG_FACTORY = new ConsoleLoggerProviderFactory();

    private static ConcurrentMap<Class, LoggerProvider> log4jLoggers = new ConcurrentHashMap();

    private static List<Class> ignoreLoggers = new ArrayList<>();


    public static LoggerProvider getLogger() {

        return DEFAULT;
    }

    public static void setIgnoreLogger(Class cls) {

        if (cls != null) {
            ignoreLoggers.add(cls);
        }
    }


    public static void removeIgnoreLogger(Class cls) {

        if (cls != null) {
            ignoreLoggers.remove(cls);
        }
    }

    public static void removeAllIgnoreLogger() {

        ignoreLoggers.clear();
    }

    public static LoggerProvider getLogger(Class cls) {

        if (cls == null) {
            return getLogger();
        }
        if (ignoreLoggers.contains(cls)) {
            return NULL_LOGGER;
        }
        String name = cls.getName();
        LoggerProvider instance = log4jLoggers.get(cls);
        if (instance != null) {
            return instance;
        } else {
            LoggerProvider newInstance = DEBUG_FACTORY.createLoggerProvider(name);
            LoggerProvider oldInstance = log4jLoggers.putIfAbsent(cls, newInstance);
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
