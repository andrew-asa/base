package com.asa.base.env.system.info;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class DiskInfo {

    /**
     * 路径
     */
    private String path;

    /**
     * 总共（M）
     */
    private double total;

    /**
     * 已经使用（M）
     */
    private double used;

    /**
     * 可用（M）
     */
    private double avail;

    public DiskInfo(String path, double total, double used, double avail) {

        this.path = path;
        this.total = total;
        this.used = used;
        this.avail = avail;
    }

    public String getPath() {

        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public double getTotal() {

        return total;
    }

    public void setTotal(double total) {

        this.total = total;
    }

    public double getUsed() {

        return used;
    }

    public void setUsed(double used) {

        this.used = used;
    }

    public double getAvail() {

        return avail;
    }

    public void setAvail(double avail) {

        this.avail = avail;
    }
}
