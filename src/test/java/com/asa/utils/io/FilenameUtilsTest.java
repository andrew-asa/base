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

    @Test
    public void isSystemWindows() {

    }

    @Test
    public void normalize() {

    }

    @Test
    public void testNormalize() {

    }

    @Test
    public void normalizeNoEndSeparator() {

    }

    @Test
    public void testNormalizeNoEndSeparator() {

    }

    @Test
    public void concat() {

    }

    @Test
    public void separatorsToUnix() {

    }

    @Test
    public void separatorsToWindows() {

    }

    @Test
    public void separatorsToSystem() {

    }

    @Test
    public void getPrefixLength() {

    }

    @Test
    public void indexOfLastSeparator() {

    }

    @Test
    public void indexOfExtension() {

    }

    @Test
    public void getPrefix() {

    }

    @Test
    public void getPath() {

    }

    @Test
    public void getPathNoEndSeparator() {

    }

    @Test
    public void getFullPath() {

    }

    @Test
    public void getFullPathNoEndSeparator() {

    }

    @Test
    public void getName() {

    }

    @Test
    public void getBaseName() {

    }

    @Test
    public void getExtension() {

    }

    @Test
    public void removeExtension() {

    }

    @Test
    public void isExtension() {

    }

    @Test
    public void testIsExtension() {

    }

    @Test
    public void testIsExtension1() {

    }

    @Test
    public void cleanPath() {
        assertEquals(FilenameUtils.cleanPath("mypath/myfile"),"mypath/myfile");
        assertEquals(FilenameUtils.cleanPath("mypath\\myfile"),"mypath/myfile");
        assertEquals(FilenameUtils.cleanPath("mypath/../mypath/myfile"),"mypath/myfile");
        assertEquals(FilenameUtils.cleanPath("mypath/myfile/../../mypath/myfile"),"mypath/myfile");
        assertEquals(FilenameUtils.cleanPath("../mypath/myfile"),"../mypath/myfile");
        assertEquals(FilenameUtils.cleanPath("../mypath/../mypath/myfile"),"../mypath/myfile");
        assertEquals(FilenameUtils.cleanPath("mypath/../../mypath/myfile"),"../mypath/myfile");
        assertEquals(FilenameUtils.cleanPath("/../mypath/myfile"),"/../mypath/myfile");
        assertEquals(FilenameUtils.cleanPath("/a/:b/../../mypath/myfile"),"/mypath/myfile");
        assertEquals(FilenameUtils.cleanPath("/"),"/");
        assertEquals(FilenameUtils.cleanPath("/mypath/../"),"/");
        assertEquals(FilenameUtils.cleanPath("mypath/.."),"");
        assertEquals(FilenameUtils.cleanPath("mypath/../."),"");
        assertEquals(FilenameUtils.cleanPath("mypath/../"),"./");
        assertEquals(FilenameUtils.cleanPath("././"),"./");
        assertEquals(FilenameUtils.cleanPath("./"),"./");
        assertEquals(FilenameUtils.cleanPath("../"),"../");
        assertEquals(FilenameUtils.cleanPath("./../"),"../");
        assertEquals(FilenameUtils.cleanPath(".././"),"../");
        assertEquals(FilenameUtils.cleanPath("file:/"),"file:/");
        assertEquals(FilenameUtils.cleanPath("file:/mypath/../"),"file:/");
        assertEquals(FilenameUtils.cleanPath("file:mypath/.."),"file:");
        assertEquals(FilenameUtils.cleanPath("file:mypath/../."),"file:");
        assertEquals(FilenameUtils.cleanPath("file:mypath/../"),"file:./");
        assertEquals(FilenameUtils.cleanPath("file:././"),"file:./");
        assertEquals(FilenameUtils.cleanPath("file:./"),"file:./");
        assertEquals(FilenameUtils.cleanPath("file:../"),"file:../");
        assertEquals(FilenameUtils.cleanPath("file:./../"),"file:../");
        assertEquals(FilenameUtils.cleanPath("file:.././"),"file:../");
        assertEquals(FilenameUtils.cleanPath("file:/mypath/spring.factories"),"file:/mypath/spring.factories");
        assertEquals(FilenameUtils.cleanPath("file:///c:/some/../path/the%20file.txt"),"file:///c:/path/the%20file.txt");
        assertEquals(FilenameUtils.cleanPath("jar:file:///c:\\some\\..\\path\\.\\the%20file.txt"),"jar:file:///c:/path/the%20file.txt");
        assertEquals(FilenameUtils.cleanPath("jar:file:///c:/some/../path/./the%20file.txt"),"jar:file:///c:/path/the%20file.txt");
    }

    @Test
    public void testGetName() {

    }
}