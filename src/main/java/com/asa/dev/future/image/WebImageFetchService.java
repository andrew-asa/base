package com.asa.dev.future.image;

import com.asa.dev.future.ResourceFetchService;
import com.asa.dev.future.ResourceFuture;
import com.asa.dev.future.ResourceLoadFuture;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author andrew_asa
 * @date 2018/10/30.
 */
public class WebImageFetchService implements ResourceFetchService<String, Image> {

    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

    @Override
    public ResourceFuture<Image> load(final String resource, final ResourceLoadFuture future) {


        final Future<Image> f = scheduler.schedule(new Callable<Image>() {

            @Override
            public Image call() throws Exception {

                URL url = new URL(resource);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("User-Agent", "Mozilla/5.0");
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5 * 1000);
                InputStream inStream = conn.getInputStream();
                byte[] btImg = readInputStream(inStream);
                return new Image(new ByteArrayInputStream(btImg));
            }
        }, 0, TimeUnit.MILLISECONDS);
        ResourceFuture resourceFuture = new ResourceFuture(f);
        new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    Image image = f.get();
                    future.onload(image);
                } catch (Exception e) {
                    future.onError(e);
                }
            }
        }).start();
        return resourceFuture;
    }

    /**
     * 根据地址获得数据的字节流
     *
     * @param strUrl 网络连接地址
     * @return
     */
    private byte[] getImageFromNetByUrl(String strUrl) {

        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();
            byte[] btImg = readInputStream(inStream);
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从输入流中获取数据
     *
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    private byte[] readInputStream(InputStream inStream) throws Exception {

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}
