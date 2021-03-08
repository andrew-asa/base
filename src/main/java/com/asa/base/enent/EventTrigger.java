package com.asa.base.enent;

/**
 * 事件触发器
 */
public interface EventTrigger {
    
    void fire(Event<Null> event);
    
    <T> void fire(Event<T> event, T param);
    
    void asyncFire(final Event<Null> event);
    
    <T> void asyncFire(final Event<T> event, final T param);
}
