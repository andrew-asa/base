package com.asa.base.enent;

/**
 * 无参数的Listener
 */
public abstract class ListenerAdaptor extends Listener<Null> {
    
    protected ListenerAdaptor() {
        
        super();
    }
    
    /**
     * 自定义优先级，适用于局部有先后关系的监听
     */
    protected ListenerAdaptor(int priority) {
        
        super(priority);
    }
    
    
    @Override
    public void on(Event event, Null param) {
        
        on(event);
    }
    
    protected abstract void on(Event event);
}
