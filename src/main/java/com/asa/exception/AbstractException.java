package com.asa.exception;

import com.asa.utils.MapUtils;

import java.util.Map;

/**
 * @author andrew_asa
 * @date 2018/11/22.
 * 抽象异常类
 */
public class AbstractException extends Exception implements ExceptionMessage {

    private String errorCode;

    private String errorMessage;

    private Map<Object, Object> attribute;

    public AbstractException() {

    }

    public AbstractException(String errorCode, String message) {

        super(message);
        this.errorMessage = message;
        this.errorCode = errorCode;
    }

    public void setErrorCode(String errorCode) {

        this.errorCode = errorCode;
    }

    @Override
    public String errorCode() {

        return errorCode;
    }

    @Override
    public String errorMessage() {

        return errorMessage;
    }

    @Override
    public Object getAttribute(Object key) {

        return MapUtils.get(attribute, key);
    }
}

