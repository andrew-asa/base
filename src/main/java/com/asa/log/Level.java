package com.asa.log;

/**
 * @author andrew_asa
 * @date 2021/3/8.
 */
public class Level {

    transient int level;
    transient String levelStr;
    transient int syslogEquivalent;

    public static final Level OFF = new Level(2147483647, "OFF", 0);
    public static final Level FATAL = new Level(50000, "FATAL", 0);
    public static final Level ERROR = new Level(40000, "ERROR", 3);
    public static final Level WARN = new Level(30000, "WARN", 4);
    public static final Level INFO = new Level(20000, "INFO", 6);
    public static final Level DEBUG = new Level(10000, "DEBUG", 7);
    public static final Level TRACE = new Level(5000, "TRACE", 7);
    public static final Level ALL = new Level(-2147483648, "ALL", 7);


    protected Level(int level, String levelStr, int syslogEquivalent) {
        this.level = level;
        this.levelStr = levelStr;
        this.syslogEquivalent = syslogEquivalent;
    }


    /**
     * 大于等于
     * @param l
     * @return
     */
    public boolean greaterThanOrEqual(Level l){
        return this.level >= l.getLevel();
    }



    public int getLevel() {

        return level;
    }
}
