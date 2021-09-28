package com.asa.utils.io;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author andrew_asa
 * @date 2021/9/28.
 */
public class FilenameUtilsTest {

    @Test
    public void applyRelativePath() {

        Assert.assertEquals(FilenameUtils.applyRelativePath("a/b/", "c"),"a/b/c");
        Assert.assertEquals(FilenameUtils.applyRelativePath("/a/b/", "c"),"/a/b/c");
        Assert.assertEquals(FilenameUtils.applyRelativePath("a/b", "c"),"a/c");
        Assert.assertEquals(FilenameUtils.applyRelativePath("/a/b", "c"),"/a/c");
        Assert.assertEquals(FilenameUtils.applyRelativePath("/a/b//ace", "c"),"/a/b//c");
        Assert.assertEquals(FilenameUtils.applyRelativePath("/a/b//ace/", "c"),"/a/b//ace/c");

        System.out.println(FilenameUtils.applyRelativePath("a/b/", "c"));
        System.out.println(FilenameUtils.applyRelativePath("/a/b/", "c"));
        System.out.println(FilenameUtils.applyRelativePath("a/b", "c"));
        System.out.println(FilenameUtils.applyRelativePath("/a/b", "c"));
        System.out.println(FilenameUtils.applyRelativePath("/a/b//ace", "c"));
        System.out.println(FilenameUtils.applyRelativePath("/a/b//ace/", "c"));
    }
}