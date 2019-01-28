package com.asa.base.env.system;

import com.asa.base.env.system.info.CommandInfo;
import com.asa.base.env.system.info.DiskInfo;
import com.asa.base.env.system.info.PortInfo;
import com.asa.base.env.system.info.ServiceInfo;

import java.util.List;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 * 系统检查官
 */
public interface SystemProsecutor {

    /**
     * 内存大小，(M)为单位
     *
     * @return
     */
    long totalMemory();

    /**
     * 磁盘相关信息
     *
     * @return
     */
    List<DiskInfo> diskInfo();

    /**
     * 防火墙状态
     *
     * @return
     */
    String firewallState();

    /**
     * 端口是否正在使用
     * port 不能为空
     *
     * @param port
     * @return
     */
    PortInfo portInUse(String port);

    /**
     * 服务启动信息
     * service 不能为空
     *
     * @param service
     * @return
     */
    ServiceInfo serviceInfo(String service);

    /**
     * 获取系统信息
     *
     * @param cmd
     * @return
     */
    CommandInfo commandInfo(String cmd);
}
