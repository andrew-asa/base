package com.asa.dev.future.image;

import com.asa.dev.future.ResourceLoadFuture;
import org.junit.Test;

/**
 * @author andrew_asa
 * @date 2018/10/30.
 */
public class WebImageFetchServiceTest {

    @Test
    public void load() throws Exception {

        WebImageFetchService fetchService = new WebImageFetchService();
        fetchService.load("http://www.easyicon.net/api/resizeApi.php?id=1206741&size=128", new ResourceLoadFuture() {

            @Override
            public void onload(Object result) {

                System.out.println("success");
            }

            @Override
            public void onError(Exception e) {

                System.out.println("fail");
            }
        });
    }
}
