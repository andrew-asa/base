package com.asa.base.local;

/**
 * @author andrew_asa
 * @date 2018/10/31.
 */
public class LocaleMarker {

    private String path;

    public LocaleMarker(String path) {

        this.path = path;
    }

    public String getPath() {

        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public static LocaleMarker create(String path) {

        return new LocaleMarker(path);
    }
}
