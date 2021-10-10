package com.asa.base.exception;

/**
 * @author andrew_asa
 * @date 2018/11/22.
 */
public interface ExceptionMessage {

    /**
     * 错误码
     *
     * @return
     */
    String errorCode();

    /**
     * 错误信息
     *
     * @return
     */
    String errorMessage();

    /**
     * 额外的错误信息，属性
     *
     * @param key
     * @return
     */
    Object getAttribute(Object key);
}
