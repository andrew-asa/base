package com.asa.log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author andrew_asa
 * @date 2021/3/8.
 */
public class LoggerFactoryTest {

    @Test
    public void getLogger() {
        LoggerFactory.getLogger(LoggerFactoryTest.class).debug("ddd");
        LoggerFactory.getLogger(LoggerFactoryTest.class).setLevel(Level.INFO);
        LoggerFactory.getLogger(LoggerFactoryTest.class).debug("ddd");
    }
}