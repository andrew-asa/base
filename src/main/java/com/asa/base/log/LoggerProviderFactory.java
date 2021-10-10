package com.asa.base.log;

/**
 * @author andrew_asa
 * @date 2021/2/20.
 */
public interface LoggerProviderFactory {

    LoggerProvider createLoggerProvider(String name);
}
