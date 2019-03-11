package com.asa.base.env.system;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author andrew_asa
 * @date 2019/3/11.
 */
public class LinuxProsecutorTest {

    @Test
    public void getSystemProperties() throws Exception {

        String text = "ftpd_connect_all_unreserved --> off";
        String[] ts =  text.split("-->");
        System.out.println(ts);
    }

}