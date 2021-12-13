package com.asa.base.enent;


import com.asa.base.lang.Filter;

/**
 * 事件模型的入口
 */
public interface EventEntry {
    
    /**
     * 监听一大堆事件
     */
    <T> void listenEvent(Event<T>[] events, Listener<T> listener);
    
    /**
     * 监听某事件
     */
    <T> void listenEvent(Event<T> eventType, Listener<T> listener);
    
    /**
     * 包含事件过滤器
     */
    <T> void listenEvent(Event<T> eventType, Listener<T> listener, Filter<T> filter);
}
