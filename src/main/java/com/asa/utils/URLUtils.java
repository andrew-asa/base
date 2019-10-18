package com.asa.utils;


/**
 * @author andrew_asa
 * @date 2019-09-24.
 */
public class URLUtils {

    /**
     * 地址拼接
     * localhost:8080 + /webroot => localhost:8080/webroot
     * localhost:8080/ + /webroot =>localhost:8080/webroot
     * localhost:8080/ + webroot =>localhost:8080/webroot
     * localhost:8080 + webroot =>localhost:8080/webroot
     *
     * @param base
     * @param path
     * @return
     */
    public static String concat(String base, String path) {

        if (StringUtils.isEmpty(base) || StringUtils.isEmpty(path)) {
            throw new IllegalArgumentException(StringUtils.messageFormat("argument base or path is empty"));
        }
        String sp = "/";
        if (!base.endsWith(sp)) {
            base = base + sp;
        }
        if (path.startsWith(sp)) {
            path = path.substring(1);
        }
        return base + path;
    }
}
