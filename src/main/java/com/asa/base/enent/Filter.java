package com.asa.base.enent;

/**
 * 过滤器
 */
public interface Filter<T> {
    
    boolean accept(T t);
}
