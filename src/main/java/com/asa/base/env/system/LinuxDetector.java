package com.asa.base.env.system;

import com.asa.base.env.SystemEnvService;
import com.asa.base.env.shell.Shell;
import com.asa.base.log.LoggerFactory;
import com.asa.base.utils.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.util.Properties;

/**
 * @author andrew_asa
 * @date 2019/5/7.
 */
public class LinuxDetector {

    private boolean centos;

    private boolean ubuntu;

    private static LinuxDetector INSTANCE = new LinuxDetector();

    private String name;

    private String version;

    private LinuxDetector() {

        init();
    }

    public static LinuxDetector getInstance() {

        return INSTANCE;
    }

    public boolean isCentos() {

        return centos;
    }

    public void setCentos(boolean centos) {

        this.centos = centos;
    }

    public boolean isUbuntu() {

        return ubuntu;
    }

    public void setUbuntu(boolean ubuntu) {

        this.ubuntu = ubuntu;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getVersion() {

        return version;
    }

    public void setVersion(String version) {

        this.version = version;
    }

    public boolean assureSystem() {

        return ubuntu || centos;
    }

    public String getFirewallStatus() {

        if (isUbuntu()) {
            return Shell.getInstance().execPipelineStr("ufw status | grep active | awk '{print $2}'");
        } else {
            return Shell.getInstance().execPipelineStr("systemctl status firewalld | grep active | awk '{print $2}'");
        }
    }

    private void init() {

        name = getLinuxSystemName();
        version = getLinuxVersion();
        systemDetector(name);
    }

    private void systemDetector(String name) {

        if (StringUtils.containsIgnoreCase(name, "ubuntu")) {
            ubuntu = true;
        }
        if (StringUtils.containsIgnoreCase(name, "CentOS")) {
            centos = true;
        }
    }

    private String getLinuxSystemName() {

        if (fileExists("/etc/redhat-release")) {
            return catName("/etc/redhat-release");
        } else if (fileExists("/etc/os-release")) {
            return catName("/etc/os-release");
        } else if (SystemEnvService.getInstance().getSystemProsecutor().serviceInfo("lsb_release").isExist()) {
            return Shell.getInstance().execStr("lsb_release -d ");
        }
        return ManagementFactory
                .getOperatingSystemMXBean().getName();
    }

    private boolean fileExists(String fn) {

        boolean exists = new File(fn).exists();
        return exists;
    }

    private String catName(String fn) {

        String cn = Shell.getInstance().execStr("cat " + fn);
        return cn;
    }

    private String getLinuxVersion() {

        try {
            Process process = Runtime.getRuntime().exec("cat /etc/os-release ");
            InputStream in = process.getInputStream();
            Properties properties = new Properties();
            properties.load(in);
            String name = "VERSION";
            if (properties.containsKey(name)) {
                String osName = properties.getProperty(name);
                return osName;
            }
        } catch (Exception e) {
            LoggerFactory.getLogger().info(e.getMessage(), e);
        }
        return ManagementFactory
                .getOperatingSystemMXBean().getVersion();
    }
}
