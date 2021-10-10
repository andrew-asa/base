package com.asa.base.service.assist;




/**
 * @author andrew_asa
 * @date 2019/5/6.
 */
public class JavaAssist {

    static {
        //try {
        //    String name = ManagementFactory.getRuntimeMXBean().getName();
        //    String pid = name.split("@")[0];
        //    VirtualMachine virtualMachine = com.sun.tools.attach.VirtualMachine.attach(pid);
        //    String path = "/Users/andrew_asa/Documents/code/github/andrew-asa/base/src/main/resources/com/asa/base/service/assist/";
        //    virtualMachine.loadAgentPath(path + "ForceGC.dylib", null);
        //    virtualMachine.detach();
        //} catch (Exception ignore) {
        //
        //}
    }

    public native static int forceGC();
}
