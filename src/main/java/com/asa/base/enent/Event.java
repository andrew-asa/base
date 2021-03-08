package com.asa.base.enent;

import java.io.Serializable;

/**
 * Fine事件对象
 * 派生类通常用enum，指定一系列的事件
 *
 * @param <T> 事件所携带的参数类型，可为Null
 */
public interface Event<T> extends Serializable {

}
