package com.asa.base.log;

/**
 * @author andrew_asa
 * @date 2021/3/8.
 */
public class ConsoleLoggerProviderFactory implements LoggerProviderFactory{

    @Override
    public LoggerProvider createLoggerProvider(String name) {

        return new ConsoleLoggerProvider(name);
    }
}
