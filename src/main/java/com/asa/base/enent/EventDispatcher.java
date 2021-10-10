package com.asa.base.enent;

import com.asa.base.log.LoggerFactory;
import com.asa.base.utils.AssistUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 事件分发
 */
public abstract class EventDispatcher {

    private static final Map<Event, Map<Listener, Filter>> LISTENER_MAP = new ConcurrentHashMap<Event, Map<Listener, Filter>>();

    private static final Executor EXECUTOR = Executors.newCachedThreadPool();

    private static final Filter<Object> DEFAULT_FILTER = new Filter<Object>() {
        @Override
        public boolean accept(Object o) {
            return true;
        }
    };
    
    /**
     * 监听一大堆事件
     */
    public static <T> void listen(Event<T>[] events, Listener<T> listener) {

        assert events != null;
        for (Event<T> event : events) {
            listen(event, listener, null);
        }
    }

    /**
     * 监听某事件
     */
    public static <T> void listen(Event<T> eventType, Listener<T> listener) {

        listen(eventType, listener, null);
    }

    /**
     * 包含事件过滤器
     */
    public static <T> void listen(Event<T> eventType, Listener<T> listener, Filter<T> filter) {

        if (eventType == null || listener == null) {
            return;
        }
        Map<Listener, Filter> map = LISTENER_MAP.get(eventType);
        if (map == null) {
            map = new ConcurrentHashMap<Listener, Filter>();
            LISTENER_MAP.put(eventType, map);
        }
        if (filter == null) {
            map.put(listener, DEFAULT_FILTER);
        } else {
            map.put(listener, filter);
        }
    }

    /**
     * 停止监听
     */
    public static void stopListen(Listener listener) {

        if (listener == null) {
            return;
        }
        for (Map.Entry<Event, Map<Listener, Filter>> entry : LISTENER_MAP.entrySet()) {
            entry.getValue().remove(listener);
        }
    }

    /**
     * 无参数的监听
     */
    public static void fire(Event<Null> event) {

        fire(event, Null.get());
    }

    public static <T> void fire(Event<T> event, T param) {

        assert event != null;

        List<Listener<T>> listeners = getListenerList(event, param);
        Collections.sort(listeners, new Comparator<Listener<T>>() {


            @Override
            public int compare(Listener<T> o1, Listener<T> o2) {
                return AssistUtils.compare(o2.getPriority(), o1.getPriority());
            }
        });
        LoggerFactory.getLogger().debug("Fire event {} ,listeners : {}.", event, listeners);
        for (Listener<T> listener : listeners) {
            fire(event, param, listener);
        }
    }

    /**
     * 异步fire
     */
    public static void asyncFire(final Event<Null> event) {

        EXECUTOR.execute(new Runnable() {

            @Override
            public void run() {

                fire(event);
            }
        });
    }

    public static <T> void asyncFire(final Event<T> event, final T param) {

        EXECUTOR.execute(new Runnable() {

            @Override
            public void run() {

                fire(event, param);
            }
        });
    }

    private static <T> void fire(Event<T> eventType, T event, Listener<T> listener) {

        try {
            listener.on(eventType, event);
        } catch (Throwable e) {
            LoggerFactory.getLogger().error(e.getMessage(), e);
        }
    }

    /**
     * 获取监听列表
     */
    @SuppressWarnings("unchecked")
    private static <T> List<Listener<T>> getListenerList(Event<T> eventType, T value) {

        List<Listener<T>> result = new ArrayList<Listener<T>>();
        if (eventType == null) {
            return result;
        }
        Map<Listener, Filter> map = LISTENER_MAP.get(eventType);
        if (map == null) {
            return result;
        }
        Filter filter;
        for (Map.Entry<Listener, Filter> entry : map.entrySet()) {
            filter = entry.getValue();
            if (Filters.accept(filter, value)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}