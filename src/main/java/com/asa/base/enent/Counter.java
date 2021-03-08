package com.asa.base.enent;

import com.asa.log.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 计数器
 */
public class Counter {
    
    //通用的到期事件
    private static final Event<Null> COUNT_EVENT = new BaseEvent<Null>();
    
    private final AtomicInteger count = new AtomicInteger(0);
    
    private final Listener<Null> listener;
    
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    
    private final Lock read = lock.readLock();
    
    private final Lock write = lock.writeLock();
    
    private final int threshold;
    
    private volatile boolean fired = false;
    
    private Counter(int threshold, Listener<Null> listener) {
        
        this.threshold = threshold;
        this.listener = listener;
    }
    
    /**
     * 创建一个计数器
     * @param threshold 阈值
     * @param listener 到达阈值时触发的事件
     * @return 计数器
     */
    public static Counter on(int threshold, Listener<Null> listener) {
        
        assert threshold > 0;
        assert listener != null;
        return new Counter(threshold, listener);
    }
    
    /**
     * 计数
     */
    public void count() {
    
        read.lock();
        try {
            int value = count.incrementAndGet();
            if (value >= threshold && !fired) {
                synchronized (this) {
                    if (!fired) {
                        try {
                            listener.on(COUNT_EVENT, null);
                        } catch (Throwable e) {
                            LoggerFactory.getLogger().error(e.getMessage(), e);
                        }
                    }
                    fired = true;
                }
            }
        } finally {
            read.unlock();
        }
    }
    
    /**
     * 重置
     */
    public void reset() {
        
        write.lock();
        try {
            fired = false;
            count.set(0);
        } finally {
            write.unlock();
        }
    }
}
