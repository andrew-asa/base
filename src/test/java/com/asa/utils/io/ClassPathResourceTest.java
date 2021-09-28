package com.asa.utils.io;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * @author andrew_asa
 * @date 2021/9/28.
 */
public class ClassPathResourceTest {

    @Ignore
    @Test
    public void testPathResource() throws Exception {

        ClassPathResource classPathResource = new ClassPathResource("com/asa/base/class_path_resource.txt");
        InputStream in = classPathResource.getInputStream();
        System.out.println(IOUtils.inputStream2String(in));
    }

    @Ignore
    @Test
    public void readLine() throws Exception {

        ClassPathResource classPathResource = new ClassPathResource("com/asa/base/weng.pdf");
        InputStream in = classPathResource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}