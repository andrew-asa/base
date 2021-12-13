package com.asa.base.lang;

/**
 * 过滤器
 */
public interface Filter<T> {
    
    boolean accept(T t);
}
