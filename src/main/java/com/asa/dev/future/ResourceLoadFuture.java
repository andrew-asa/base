package com.asa.dev.future;

/**
 * @author andrew_asa
 * @date 2018/10/30.
 * 资源加载回调
 */
public interface ResourceLoadFuture<R> {

    /**
     * 完成方法回调
     *
     * @param result
     */
    void onload(R result);

    void onError(Exception e);
}
