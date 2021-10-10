package com.asa.base.exception;

import com.asa.base.utils.MapUtils;

import java.util.Map;

/**
 * @author andrew_asa
 * @date 2018/11/22.
 * 抽象异常时异常
 */
public class AbstractRuntimeException extends RuntimeException implements ExceptionMessage {

    private String errorCode;

    private String errorMessage;

    private Map<Object, Object> attribute;

    public AbstractRuntimeException() {

    }

    public AbstractRuntimeException(String errorCode, String errorMessage) {

        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
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
