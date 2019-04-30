package com.asa.base.env;

import com.asa.base.env.system.LinuxProsecutor;
import com.asa.base.env.system.MacProsecutor;
import com.asa.base.env.system.SystemProsecutor;
import com.asa.base.env.system.WindowProsecutor;
import com.asa.third.org.apache.commons.lang3.SystemUtils;

import java.math.MathContext;

/**
 * @author andrew_asa
 * @date 2019/1/28.
 */
public class SystemEnvService {

    private static SystemEnvService INSTANCE = new SystemEnvService();

    private SystemProsecutor mac;

    private SystemProsecutor linux;

    private SystemProsecutor window;

    private SystemEnvService() {

    }

    public static SystemEnvService getInstance() {

        return INSTANCE;
    }

    public SystemProsecutor getSystemProsecutor() {

        if (SystemUtils.IS_OS_WINDOWS) {
            if (window == null) {
                window = new WindowProsecutor();
            }
            return window;
        } else if (SystemUtils.IS_OS_MAC) {
            if (mac == null) {
                mac = new MacProsecutor();
            }
            return mac;
        } else {
            if (linux == null) {
                linux = new LinuxProsecutor();
            }
            return linux;
        }
    }
}
