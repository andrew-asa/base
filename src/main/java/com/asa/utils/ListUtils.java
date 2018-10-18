package com.asa.utils;

import java.util.Collection;
import java.util.List;

/**
 * @author andrew_asa
 * @date 2018/10/14.
 */
public class ListUtils {

    public static boolean isEmpty(List list) {

        return list == null || list.isEmpty();
    }

    public static boolean isNotEmpty(List list) {

        return list != null && !list.isEmpty();
    }

    /**
     * 如果缺失则放进去
     *
     * @param list
     * @param e
     * @param <E>
     */
    public static <E> void putIfAbsent(Collection<E> list, E e) {

        if (list != null && e != null && !list.contains(e)) {
            list.add(e);
        }
    }

    /**
     * list 的长度
     *
     * @param list
     * @return
     */
    public static int length(List list) {

        return isEmpty(list) ? 0 : list.size();
    }
}
