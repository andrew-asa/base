package com.asa.log;


/**
 * @author andrew_asa
 * @date 2018/11/22.
 * system.out log
 */
public class SystemOutLoggerProvider implements LoggerProvider {

    @Override
    public void debug(String msg) {

        System.out.println("[DEBUG]" + msg);
    }

    @Override
    public void debug(String msg, Object... parameters) {

        FormattingTuple tuple = MessageFormatter.arrayFormat(msg, parameters);
        System.out.println("[DEBUG]" + tuple.getMessage());
    }

    @Override
    public void debug(String msg, Throwable throwable) {

        System.out.println("[DEBUG]" + msg);
        throwable.printStackTrace();
    }

    @Override
    public void debug(Throwable throwable, String msg, Object... parameters) {

        debug(msg, parameters);
        throwable.printStackTrace();
    }

    @Override
    public void info(String msg) {

        System.out.println("[INFO]" + msg);
    }

    @Override
    public void info(String msg, Object... parameters) {

        FormattingTuple tuple = MessageFormatter.arrayFormat(msg, parameters);
        System.out.println("[INFO]" + tuple.getMessage());
    }

    @Override
    public void info(String msg, Throwable throwable) {

        info(msg);
        throwable.printStackTrace();
    }

    @Override
    public void info(Throwable throwable, String msg, Object... parameters) {

        info(msg, parameters);
        throwable.printStackTrace();
    }

    @Override
    public void warn(String msg) {

        System.err.println("[WARN]" + msg);
    }

    @Override
    public void warn(String msg, Object... args) {

        FormattingTuple var4 = MessageFormatter.arrayFormat(msg, args);
        System.err.println("[WARN]" + var4.getMessage());
    }

    @Override
    public void warn(String msg, Throwable throwable) {

        System.err.println("[WARN]" + msg);
        throwable.printStackTrace();
    }

    @Override
    public void warn(Throwable throwable, String msg, Object... parameters) {

        FormattingTuple var4 = MessageFormatter.arrayFormat(msg, parameters);
        System.err.println("[WARN]" + var4.getMessage());
        throwable.printStackTrace();
    }

    @Override
    public void error(String msg) {

        System.err.println("[ERROR]" + msg);
    }

    @Override
    public void error(String msg, Object... args) {

        FormattingTuple tuple = MessageFormatter.arrayFormat(msg, args);
        System.err.println("[ERROR]" + tuple.getMessage());
    }

    @Override
    public void error(String msg, Throwable throwable) {

        System.err.println("[ERROR]" + msg);
        throwable.printStackTrace();
    }

    @Override
    public void error(Throwable throwable, String msg, Object... parameters) {

        FormattingTuple tuple = MessageFormatter.arrayFormat(msg, parameters);
        System.err.println("[ERROR]" + tuple.getMessage());
        throwable.printStackTrace();
    }

    @Override
    public void trace(String msg) {

        System.out.println("[TRACE]" + msg);
    }

    @Override
    public void trace(String msg, Object... args) {

        FormattingTuple tuple = MessageFormatter.arrayFormat(msg, args);
        System.out.println("[TRACE]" + tuple.getMessage());
    }

    @Override
    public void trace(String msg, Throwable throwable) {

        System.out.println("[TRACE]" + msg);
        throwable.printStackTrace();
    }

    @Override
    public void trace(Throwable throwable, String msg, Object... parameters) {

        trace(msg, parameters);
        throwable.printStackTrace();
    }
}
