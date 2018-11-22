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

        FormattingTuple var3 = MessageFormatter.arrayFormat(msg, parameters);
        System.out.println("[DEBUG]" + var3.getMessage());
    }

    @Override
    public void info(String msg) {

        System.out.println("[INFO]" + msg);
    }

    @Override
    public void info(String msg, Object... parameters) {

        FormattingTuple var3 = MessageFormatter.arrayFormat(msg, parameters);
        System.out.println("[INFO]" + var3.getMessage());
    }

    @Override
    public void warn(String msg) {

        System.err.println("[WARN]" + msg);
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
    public void error(String msg, Throwable throwable) {

        System.err.println("[ERROR]" + msg);
        throwable.printStackTrace();
    }

    @Override
    public void error(Throwable throwable, String msg, Object... parameters) {

        FormattingTuple var4 = MessageFormatter.arrayFormat(msg, parameters);
        System.err.println("[ERROR]" + var4.getMessage());
        throwable.printStackTrace();
    }
}
