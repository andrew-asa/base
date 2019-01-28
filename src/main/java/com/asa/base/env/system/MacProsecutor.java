package com.asa.base.env.system;


import com.asa.base.env.shell.Shell;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class MacProsecutor extends DefaultSystemProsecutor {

    @Override
    public long totalMemory() {

        String cmd = "system_profiler SPHardwareDataType | grep \"  Memory:\" | awk '{print $2}'";
        int mm = Shell.getInstance().execPipelineInt(cmd, -1);
        if (mm != -1) {
            return mm * 1024;
        }
        return 0;
    }
}
