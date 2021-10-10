/*
 * Copyright(c) 2001-2010, FineReport Inc, All Rights Reserved.
 */
package com.asa.base.utils;

/**
 * 编码相关的常量
 */
public class EncodeConstants {

    private EncodeConstants() {

    }

    /**
     * GBK编码
     */
    public static final String ENCODING_GBK = "GBK";

    /**
     * BIG5编码
     */
    public static final String ENCODING_BIG5 = "BIG5";

    /**
     * iso-8859-1编码
     */
    public static final String ENCODING_ISO_8859_1 = "ISO-8859-1";

    /**
     * utf-8编码
     */
    public static final String ENCODING_UTF_8 = "UTF-8";

    /**
     * utf-16编码
     */
    public static final String ENCODING_UTF_16 = "UTF-16";

    /**
     * euc_jp编码
     */
    public static final String ENCODING_EUC_JP = "EUC_JP";

    /**
     * euc_kr编码
     */
    public static final String ENCODING_EUC_KR = "EUC_KR";

    /**
     * CP850编码
     */
    public static final String ENCODING_CP850 = "CP850";

    /**
     * 所有编码的集合
     */
    public static final String[] ENCODING_ARRAY = {
            ENCODING_GBK,
            ENCODING_BIG5,
            ENCODING_ISO_8859_1,
            ENCODING_UTF_8,
            ENCODING_UTF_16,
            ENCODING_EUC_JP,
            ENCODING_EUC_KR,
            ENCODING_CP850
    };

    /**
     * 所有编码（包括不编码的情况 ）的集合
     */
    public static final String[] ALL_ENCODING_ARRAY = {
            "",
            ENCODING_GBK,
            ENCODING_BIG5,
            ENCODING_ISO_8859_1,
            ENCODING_UTF_8,
            ENCODING_UTF_16,
            ENCODING_EUC_JP,
            ENCODING_EUC_KR,
            ENCODING_CP850
    };
}