package com.asa.base.env.system;

import com.asa.base.env.shell.Shell;
import com.asa.base.utils.StringUtils;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 */
public class CentOSProsecutor extends LinuxProsecutor {

    @Override
    public String firewallState() {

        String s = Shell.getInstance().execStr("firewall-cmd --state");
        if (StringUtils.isNotEmpty(s)) {
            return s;
        } else {
            return "no running";
        }
    }
}
