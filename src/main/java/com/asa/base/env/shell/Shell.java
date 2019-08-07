package com.asa.base.env.shell;

import com.asa.log.LoggerFactory;
import com.asa.utils.ListUtils;
import com.asa.utils.StringUtils;
import com.asa.utils.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author andrew_asa
 * @date 2019/1/23.
 * shell 相关
 */
public class Shell {

    private static Shell INSTANCE = new Shell();

    private Shell() {

    }

    public static Shell getInstance() {

        return INSTANCE;
    }

    public List<String> execStrList(String cmd) {

        return execStrList(cmd, 100);
    }

    public List<String> execStrList(String cmd, int maxLine) {

        List<String> ret = new ArrayList<String>();
        assert cmd != null;
        Process process = null;
        Reader reader = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
            InputStream inputStream = process.getInputStream();
            reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null && i++ < maxLine) {
                ret.add(line);
            }
        } catch (Exception e) {
            LoggerFactory.getLogger().error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(reader);
            if (process != null) {
                process.destroy();
            }
        }
        return ret;
    }

    public String execStr(String cmd) {

        List<String> ret = execStrList(cmd);
        if (ListUtils.isNotEmpty(ret)) {
            return ret.get(0);
        }
        return StringUtils.EMPTY;
    }

    public List<String> execPipelineStrList(String cmd) {

        return execPipelineStrList(cmd, 100);
    }

    public List<String> execPipelineStrList(String cmd, int maxLine) {

        assert cmd != null;
        List<String> ret = new ArrayList<String>();
        Process process = null;
        Reader reader = null;
        try {
            String[] command = {"/bin/sh", "-c", cmd};
            process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null && i++ < maxLine) {
                ret.add(line);
            }
        } catch (Exception e) {
            LoggerFactory.getLogger().error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(reader);
            if (process != null) {
                process.destroy();
            }
        }
        return ret;
    }

    public String execPipelineStr(String cmd) {

        List<String> ret = execPipelineStrList(cmd);
        if (ListUtils.isNotEmpty(ret)) {
            return ret.get(0);
        }
        return StringUtils.EMPTY;
    }

    public int execInt(String cmd, int defaultValue) {

        String str = execStr(cmd);
        if (StringUtils.isNotEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Throwable throwable) {
                LoggerFactory.getLogger().error(throwable.getMessage(), throwable);
            }
        }
        return defaultValue;
    }

    /**
     * 执行管道命令并返回int
     *
     * @param cmd
     * @param defaultValue
     * @return
     */
    public int execPipelineInt(String cmd, int defaultValue) {

        String str = execPipelineStr(cmd);
        if (StringUtils.isNotEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Throwable throwable) {
                LoggerFactory.getLogger().error(throwable.getMessage(), throwable);
            }
        }
        return defaultValue;
    }

    /**
     * 是否包含某命令
     *
     * @param cmd
     * @return
     */
    public boolean containExec(String cmd) {

        assert cmd != null;
        return StringUtils.isNotEmpty(execStr("whereis " + cmd));
    }

    public boolean ping(String ipAddress) {

        return ping(ipAddress, 3000);
    }


    public boolean ping(String ipAddress, int timeOut) {

        try {
            return InetAddress.getByName(ipAddress).isReachable(timeOut);
        } catch (IOException e) {
            LoggerFactory.getLogger().error(e.getMessage(), e);
        }
        return false;
    }
}
