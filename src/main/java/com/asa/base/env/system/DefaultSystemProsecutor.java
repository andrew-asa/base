package com.asa.base.env.system;

import com.asa.base.env.shell.Shell;
import com.asa.base.env.system.info.CommandInfo;
import com.asa.base.env.system.info.DiskInfo;
import com.asa.base.env.system.info.PortInfo;
import com.asa.base.env.system.info.ServiceInfo;
import com.asa.utils.ListUtils;
import com.asa.utils.StringUtils;
import com.asa.utils.SystemUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 * 默认系统检查官
 */
public class DefaultSystemProsecutor implements SystemProsecutor {

    @Override
    public long totalMemory() {

        return 0;
    }

    @Override
    public List<DiskInfo> diskInfo() {

        List<DiskInfo> infos = new ArrayList<DiskInfo>();
        if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_LINUX) {
            List<String> infostr = Shell.getInstance().execStrList("df -hl");
            if (ListUtils.isNotEmpty(infostr)) {
                for (String item : infostr.subList(1, infostr.size())) {
                    String[] is = item.split("\\s+");
                    String ps = is[0];
                    String ts = is[1];
                    String us = is[2];
                    String as = is[3];
                    DiskInfo info = new DiskInfo(ps, toM(ts), toM(us), toM(as));
                    infos.add(info);
                }
            }
        }
        return infos;
    }

    @Override
    public String firewallState() {

        return "当前系统还未支持该项检测";
    }

    public double toM(String s) {

        String ss = getNumber(s);
        if (StringUtils.containsIgnoreCase(s, "g")) {
            return Double.parseDouble(ss) * 1024;
        } else if (StringUtils.containsIgnoreCase(s, "m")) {
            return Double.parseDouble(ss);
        } else if (StringUtils.containsIgnoreCase(s, "k")) {
            return Double.parseDouble(ss) / 1024;
        }
        return -1;
    }

    private Pattern NUMBER = Pattern.compile("\\d+");

    private String getNumber(String s) {

        Matcher m = NUMBER.matcher(s);
        m.find();
        return m.group();
    }

    @Override
    public PortInfo portInUse(String port) {

        assert StringUtils.isNotEmpty(port);
        List<String> str = Shell.getInstance().execStrList(StringUtils.messageFormat("lsof -i:{}", port));
        boolean inUse = ListUtils.isNotEmpty(str);
        PortInfo portInfo = new PortInfo(port, inUse);
        if (inUse) {
            String item = str.get(1);
            String[] items = item.split("\\s+");
            portInfo.setPid(items[1]);
        }
        return portInfo;
    }

    @Override
    public ServiceInfo serviceInfo(String service) {

        assert StringUtils.isNotEmpty(service);
        String str = Shell.getInstance().execPipelineStr(StringUtils.messageFormat("ps -ef | grep {}", service));
        str = str.trim();
        boolean exist = StringUtils.isNotEmpty(str);
        ServiceInfo serviceInfo = new ServiceInfo(service, exist);
        if (exist) {
            serviceInfo.setPid(StringUtils.splitWithBlankAndSafeGetItem(str, 1, StringUtils.EMPTY));
        }
        return serviceInfo;
    }

    @Override
    public CommandInfo commandInfo(String cmd) {

        assert StringUtils.isNotEmpty(cmd);
        String s = Shell.getInstance().execStr("command -v " + cmd);
        boolean exist = StringUtils.isNotEmpty(s);
        CommandInfo info = new CommandInfo(cmd, exist);
        if (exist) {
            info.setPath(s.trim());
        }
        return info;
    }

    @Override
    public Map<String, String> getSystemProperties() {

        return new HashMap<String, String>();
    }
}
