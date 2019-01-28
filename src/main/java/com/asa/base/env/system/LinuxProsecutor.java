package com.asa.base.env.system;


import com.asa.base.env.shell.Shell;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class LinuxProsecutor extends DefaultSystemProsecutor {

    @Override
    public long totalMemory() {

        String cmd = "cat /proc/meminfo | grep MemTotal | awk '{print $2}'";
        return Shell.getInstance().execPipelineInt(cmd, -1);
    }
}
