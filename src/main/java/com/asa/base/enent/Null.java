package com.asa.base.enent;

/**
 * 指代事件模型中的无参数事件
 */
public class Null {
    
    private static Null INSTANCE = new Null();
    
    private Null() {}
    
    public static Null get() {
        
        return INSTANCE;
    }
}
