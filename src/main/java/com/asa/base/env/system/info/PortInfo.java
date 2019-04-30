package com.asa.base.env.system.info;

import com.asa.utils.AssistUtils;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 * 端口使用情况
 */
public class PortInfo {

    private String port;

    private boolean inUse;

    private String pid;

    public PortInfo(String port, boolean inUse) {

        this.port = port;
        this.inUse = inUse;
    }

    public String getPort() {

        return port;
    }

    public void setPort(String port) {

        this.port = port;
    }

    public boolean isInUse() {

        return inUse;
    }

    public void setInUse(boolean inUse) {

        this.inUse = inUse;
    }

    public String getPid() {

        return pid;
    }

    public void setPid(String pid) {

        this.pid = pid;
    }

    @Override
    public String toString() {

        return "{port={" + port + "},pid={" + pid + "}}";
    }
}
