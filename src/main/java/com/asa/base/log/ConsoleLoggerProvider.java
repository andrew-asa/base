package com.asa.base.log;

import com.asa.base.log.Level;
/**
 * @author andrew_asa
 * @date 2018/11/22.
 * system.out log
 * 控制台日记输出
 */
public class ConsoleLoggerProvider implements LoggerProvider {

    private Level level = Level.ALL;

    private String name;

    public ConsoleLoggerProvider(String name) {

        this.name = name;
    }

    @Override
    public void setLevel(Level level) {

        this.level = level;
    }

    @Override
    public void debug(String msg) {

        if (Level.DEBUG.greaterThanOrEqual(level)) {
            System.out.println("[DEBUG]" + msg);
        }
    }

    @Override
    public void debug(String msg, Object... parameters) {

        FormattingTuple tuple = MessageFormatter.arrayFormat(msg, parameters);
        debug(tuple.getMessage());
    }

    @Override
    public void debug(Class cls, String msg, Object... parameters) {

        if (cls != null) {
            String tMsg = "[" + cls.getName() + "] " + msg;
            debug(tMsg, parameters);
        }
    }

    @Override
    public void debug(String msg, Throwable throwable) {

        if (Level.DEBUG.greaterThanOrEqual(level)) {
            System.out.println("[DEBUG]" + msg);
            throwable.printStackTrace();
        }
    }

    @Override
    public void debug(Throwable throwable, String msg, Object... parameters) {

        if (Level.DEBUG.greaterThanOrEqual(level)) {
            debug(msg, parameters);
            throwable.printStackTrace();
        }
    }

    @Override
    public void debug(Class cls, Throwable throwable, String msg, Object... parameters) {

        if (Level.DEBUG.greaterThanOrEqual(level)) {
            debug(cls, msg, parameters);
            throwable.printStackTrace();
        }
    }

    @Override
    public void info(String msg) {

        if (Level.INFO.greaterThanOrEqual(level)) {
            System.out.println("[INFO]" + msg);
        }
    }

    @Override
    public void info(String msg, Object... parameters) {

        FormattingTuple tuple = MessageFormatter.arrayFormat(msg, parameters);
        info(tuple.getMessage());
    }

    @Override
    public void info(String msg, Throwable throwable) {

        if (Level.INFO.greaterThanOrEqual(level)) {
            info(msg);
            throwable.printStackTrace();
        }
    }

    @Override
    public void info(Throwable throwable, String msg, Object... parameters) {

        if (Level.INFO.greaterThanOrEqual(level)) {
            info(msg);
            throwable.printStackTrace();
        }
    }

    @Override
    public void warn(String msg) {

        if (Level.WARN.greaterThanOrEqual(level)) {
            System.err.println("[WARN]" + msg);
        }
    }

    @Override
    public void warn(String msg, Object... args) {

        FormattingTuple var4 = MessageFormatter.arrayFormat(msg, args);
        warn(var4.getMessage());
    }

    @Override
    public void warn(String msg, Throwable throwable) {

        if (Level.WARN.greaterThanOrEqual(level)) {
            System.err.println("[WARN]" + msg);
            throwable.printStackTrace();
        }
    }

    @Override
    public void warn(Throwable throwable, String msg, Object... parameters) {

        if (Level.WARN.greaterThanOrEqual(level)) {
            FormattingTuple var4 = MessageFormatter.arrayFormat(msg, parameters);
            System.err.println("[WARN]" + var4.getMessage());
            throwable.printStackTrace();
        }
    }

    @Override
    public void error(String msg) {

        if (Level.ERROR.greaterThanOrEqual(level)) {
            System.err.println("[ERROR]" + msg);
        }
    }

    @Override
    public void error(String msg, Object... args) {

        if (Level.ERROR.greaterThanOrEqual(level)) {
            FormattingTuple tuple = MessageFormatter.arrayFormat(msg, args);
            error(tuple.getMessage());
        }
    }

    @Override
    public void error(String msg, Throwable throwable) {

        if (Level.ERROR.greaterThanOrEqual(level)) {
            System.err.println("[ERROR]" + msg);
            throwable.printStackTrace();
        }
    }

    @Override
    public void error(Throwable throwable, String msg, Object... parameters) {

        if (Level.ERROR.greaterThanOrEqual(level)) {
            FormattingTuple tuple = MessageFormatter.arrayFormat(msg, parameters);
            System.err.println("[ERROR]" + tuple.getMessage());
            throwable.printStackTrace();
        }
    }

    @Override
    public void trace(String msg) {

        if (Level.TRACE.greaterThanOrEqual(level)) {
            System.out.println("[TRACE]" + msg);
        }
    }

    @Override
    public void trace(String msg, Object... args) {

        FormattingTuple tuple = MessageFormatter.arrayFormat(msg, args);
        trace(tuple.getMessage());
    }

    @Override
    public void trace(String msg, Throwable throwable) {

        if (Level.TRACE.greaterThanOrEqual(level)) {
            System.out.println("[TRACE]" + msg);
            throwable.printStackTrace();
        }
    }

    @Override
    public void trace(Throwable throwable, String msg, Object... parameters) {

        if (Level.TRACE.greaterThanOrEqual(level)) {
            trace(msg, parameters);
            throwable.printStackTrace();
        }
    }
}
