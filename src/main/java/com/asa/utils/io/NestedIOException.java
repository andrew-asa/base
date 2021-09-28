package com.asa.utils.io;

import com.asa.lang.Nullable;

import java.io.IOException;

/**
 * @author andrew_asa
 * @date 2021/9/28.
 */
public class NestedIOException extends IOException {


    public NestedIOException(String msg) {
        super(msg);
    }


    public NestedIOException(@Nullable String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }

    @Override
    public String getMessage() {
        return NestedExceptionUtils.buildMessage(super.getMessage(), getCause());
    }

}
