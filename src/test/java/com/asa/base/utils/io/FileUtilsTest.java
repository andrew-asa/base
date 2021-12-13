package com.asa.base.utils.io;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author andrew_asa
 * @date 2021/12/13.
 */
public class FileUtilsTest {

    @Ignore
    @Test
    public void systemFilePathToString() throws IOException {

        System.out.println(FileUtils.systemFilePathToString("/etc/hosts"));
    }

    @Test
    public void stringSaveToSystemFilePath() {

    }

    @Test
    public void testStringSaveToSystemFilePath() {

    }

    @Ignore
    @Test
    public void isSameFileName() {

        String path = this.getClass().getResource("testFile.txt").getPath();
        Assert.assertTrue(FileUtils.isSameFileName(new File(path), "testFile.txt"));
        Assert.assertFalse(FileUtils.isSameFileName(new File(path), "testFile1.txt"));
    }

    @Ignore
    @Test
    public void existFile() {

        String path = this.getClass().getResource("testFile.txt").getPath();
        Assert.assertTrue(FileUtils.existFile(new File(path).getParentFile(), "testFile.txt"));
        path = new File(path).getParent();
        Assert.assertTrue(FileUtils.existFile(path, "testFile.txt"));
        Assert.assertFalse(FileUtils.existFile(path, "testFile1111.txt"));
    }

    @Test
    public void testExistFile() {

        String path = this.getClass().getResource("./").getPath();
        Assert.assertTrue(FileUtils.existFile(path, "testFile.txt", 0));
        Assert.assertFalse(FileUtils.existFile(path, "testFile11.txt", 0));
        path = this.getClass().getResource("../").getPath();
        Assert.assertFalse(FileUtils.existFile(path, "testFile.txt", 0));
        Assert.assertTrue(FileUtils.existFile(path, "testFile.txt", 1));
        Assert.assertTrue(FileUtils.existFile(path, "testFile.txt", 2));
    }

    @Test
    public void testExistFile1() {

    }

    @Test
    public void testExistFile2() {

    }
}
