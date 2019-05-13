package com.asa.service.assist;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author andrew_asa
 * @date 2019/5/6.
 */

public class JavaAssistDemo {

    public static void main(String... args) throws InterruptedException {

        byte[] bytes = new byte[200000];
        for (int i = 0; i < 200000; i++) {
            bytes[i] = 1;
        }
        bytes = null;
        System.out.println("memory filled!");
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {

                System.out.println("GC");
                JavaAssist.forceGC();
            }
        }, 15000);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
