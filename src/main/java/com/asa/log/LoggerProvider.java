package com.asa.log;

/**
 * @author andrew_asa
 * @date 2018/11/22.
 */
public interface LoggerProvider {

    void debug(String msg);

    void debug(String msg, Object... parameters);

    void info(String msg);

    void info(String msg, Object... parameters);

    void warn(String msg);

    void warn(String msg, Throwable throwable);

    void warn(Throwable throwable, String msg, Object... parameters);

    void error(String msg);

    void error(String msg, Throwable throwable);

    void error(Throwable throwable, String msg, Object... parameters);
}
