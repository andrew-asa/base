package com.asa.base.env.system.info;

/**
 * @author andrew_asa
 * @date 2019/1/24.
 */
public class CommandInfo {

    private String name;

    private boolean exist;

    private String path;

    public CommandInfo(String name, boolean exist) {

        this.name = name;
        this.exist = exist;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public boolean isExist() {

        return exist;
    }

    public void setExist(boolean exist) {

        this.exist = exist;
    }

    public String getPath() {

        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }
}
