package com.asa.base.enent;

/**
 * 监听器
 *
 * @param <T> 监听的事件附加参数类型，可为Null
 */
public abstract class Listener<T> {
    
    private final int priority;
    
    protected Listener() {
        
        this.priority = 0;
    }
    
    /**
     * 自定义优先级，适用于局部有先后关系的监听
     */
    protected Listener(int priority) {
        
        this.priority = priority;
    }
    
    /**
     * 防止具体的监听重写hashCode和equals
     */
    @Override
    public final boolean equals(Object object) {
        
        return this == object;
    }
    
    @Override
    public final int hashCode() {
        
        return super.hashCode();
    }
    
    final int getPriority() {
        
        return priority;
    }
    
    /**
     * on
     */
    public abstract void on(Event event, T param);
}
