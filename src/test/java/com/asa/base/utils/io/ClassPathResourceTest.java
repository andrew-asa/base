package com.asa.base.utils.io;

import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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

        Resource resource = new ClassPathResource("com/asa/base/wengao2.pdf");
        InputStream in = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        IOUtils.closeQuietly(in);
    }

    @Ignore
    @Test
    public void readLine2() throws Exception {

        Resource resource = new FileSystemResource("/Users/andrew_asa/Downloads/黑体.pdf");
        InputStream in = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        IOUtils.closeQuietly(in);
    }
}