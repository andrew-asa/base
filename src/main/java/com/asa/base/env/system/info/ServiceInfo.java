package com.asa.base.env.system.info;

/**
 * @author andrew_asa
 * @date 2019/1/24.
 * 服务信息，比如tomcat 等服务是否开启
 */
public class ServiceInfo {

    private String name;

    private String pid;

    /**
     * 是否存在
     */
    private boolean exist;

    public ServiceInfo(String name, boolean exist) {

        this.name = name;
        this.exist = exist;
    }

    public boolean isExist() {

        return exist;
    }

    public void setExist(boolean exist) {

        this.exist = exist;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPid() {

        return pid;
    }

    public void setPid(String pid) {

        this.pid = pid;
    }
}
