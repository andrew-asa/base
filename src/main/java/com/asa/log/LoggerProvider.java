package com.asa.log;

/**
 * @author andrew_asa
 * @date 2018/11/22.
 */
public interface LoggerProvider {

    void debug(String msg);

    void debug(String msg, Object... parameters);

    void debug(String msg, Throwable throwable);

    void debug(Throwable throwable, String msg, Object... parameters);

    void info(String msg);

    void info(String msg, Object... parameters);

    void info(String msg, Throwable throwable);

    void info(Throwable throwable, String msg, Object... parameters);

    void warn(String msg);

    void warn(String msg, Object... args);

    void warn(String msg, Throwable throwable);

    void warn(Throwable throwable, String msg, Object... parameters);

    void error(String msg);

    void error(String msg, Object... args);

    void error(String msg, Throwable throwable);

    void error(Throwable throwable, String msg, Object... parameters);

    void trace(String msg);

    void trace(String msg, Object... args);

    void trace(String msg, Throwable throwable);

    void trace(Throwable throwable, String msg, Object... parameters);
}
