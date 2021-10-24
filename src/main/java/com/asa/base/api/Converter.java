package com.asa.base.api;

/**
 * @author andrew_asa
 * @date 2021/10/17.
 */
public interface Converter<input, output> {

    /**
     * 转换
     *
     * @param input
     * @return
     */
    output convert(input input) throws Exception;
}
