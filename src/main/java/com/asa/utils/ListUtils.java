package com.asa.utils;

import java.util.ArrayList;
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

    /**
     * array 数组转list
     *
     * @param elements
     * @param <T>
     * @return
     */
    public static <T> List<T> arrayToList(T... elements) {

        ArrayList<T> result = new ArrayList<T>();
        if (elements != null) {
            for (T elem : elements) {
                result.add(elem);
            }
        }
        return result;
    }

    /**
     * 是否包含
     *
     * @param items
     * @param item
     * @param <T>
     * @return
     */
    public static <T> boolean contain(List<T> items, T item) {

        if (items != null && item != null) {
            return items.contains(item);
        }
        return false;
    }

    /**
     * 确保list 不为null对象
     *
     * @param list
     * @param <E>
     * @return
     */
    public static <E> List<E> ensureNotNull(List<E> list) {

        if (list == null) {
            return new ArrayList<E>();
        }
        return list;
    }
}
