package com.asa.dev.future;

/**
 * @author andrew_asa
 * @date 2018/10/30.
 */
public interface ResourceFetchService<S, R> {

    /**
     * 异步加载资源
     *
     * @param resource
     * @param future
     * @return
     */
    ResourceFuture<R> load(S resource, ResourceLoadFuture<R> future);
}
