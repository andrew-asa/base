package com.asa.dev.future;


import java.util.concurrent.Future;

/**
 * @author andrew_asa
 * @date 2018/10/30.
 */
public class ResourceFuture<T> {

    private Future<T> future;

    public ResourceFuture(Future<T> future) {

        this.future = future;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {

        return future.cancel(mayInterruptIfRunning);
    }

    public boolean isCancelled() {

        return future.isCancelled();
    }

    public boolean isDone() {

        return future.isDone();
    }
}
