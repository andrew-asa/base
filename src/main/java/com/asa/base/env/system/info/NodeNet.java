package com.asa.base.env.system.info;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class NodeNet {

    private String ip;

    private boolean reachable;

    public NodeNet(String ip, boolean reachable) {

        this.ip = ip;
        this.reachable = reachable;
    }

    public String getIp() {

        return ip;
    }

    public void setIp(String ip) {

        this.ip = ip;
    }

    public boolean isReachable() {

        return reachable;
    }

    public void setReachable(boolean reachable) {

        this.reachable = reachable;
    }
}
