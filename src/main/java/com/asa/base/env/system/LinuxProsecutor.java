package com.asa.base.env.system;


import com.asa.base.env.shell.Shell;
import com.asa.base.utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class LinuxProsecutor extends DefaultSystemProsecutor {

    @Override
    public long totalMemory() {

        String cmd = "cat /proc/meminfo | grep MemTotal | awk '{print $2}'";
        int kb = Shell.getInstance().execPipelineInt(cmd, -1);
        return kb / 1024;
    }

    @Override
    public Map<String, String> getSystemProperties() {
        // selinux sftp 检测
        Map<String, String> ret = new HashMap<String, String>();
        List<String> infos = Shell.getInstance().execPipelineStrList("getsebool -a | grep ftpd");
        for (String info : infos) {
            if (StringUtils.containsIgnoreCase(info, "-->")) {
                String[] is = info.split("-->");
                if (is != null && is.length == 2) {
                    String key = is[0];
                    String value = is[1];
                    if (key != null && value != null) {
                        ret.put(key.trim(), value.trim());
                    }
                }
            }
        }
        return ret;
    }
}
