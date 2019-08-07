package com.asa.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author andrew_asa
 * @date 2018/10/14.
 */
public class ListUtils {

    /**
     * 是否为空
     *
     * @param list
     * @return
     */
    public static boolean isEmpty(List list) {

        return list == null || list.isEmpty();
    }

    /**
     * 非空
     *
     * @param list
     * @return
     */
    public static boolean isNotEmpty(List list) {

        return list != null && !list.isEmpty();
    }

    /**
     * 如果缺失则放进去
     *
     * @param list
     * @param e
     * @param <T>
     */
    public static <T> void putIfAbsent(Collection<T> list, T e) {

        if (list != null && e != null && !list.contains(e)) {
            list.add(e);
        }
    }


    /**
     * 安全添加
     *
     * @param list
     * @param e
     * @param <T>
     */
    public static <T> void safeAdd(Collection<T> list, T e) {

        if (list != null && e != null) {
            list.add(e);
        }
    }

    public static <T> void safeAdd(Collection<T> list, Collection<T> collection) {

        if (list != null && collection != null) {
            for (T c : collection) {
                list.add(c);
            }
        }
    }

    /**
     * 安全删除
     *
     * @param list
     * @param e
     * @param <T>
     */
    public static <T> void safeRemove(Collection<T> list, T e) {

        if (list != null && e != null) {
            list.remove(e);
        }
    }

    /**
     * 安全检查
     *
     * @param list
     * @param collection
     * @param <T>
     */
    public static <T> void safeRemove(Collection<T> list, Collection<T> collection) {

        if (list != null && collection != null) {
            for (T c : collection) {
                safeRemove(list, c);
            }
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
     * @param <T>
     * @return
     */
    public static <T> List<T> ensureNotNull(List<T> list) {

        if (list == null) {
            return new ArrayList<T>();
        }
        return list;
    }

    /**
     * 删除元素
     *
     * @param list
     * @param item
     * @param <T>
     */
    public static <T> void remove(List<T> list, T item) {

        if (list != null && item != null) {
            list.remove(item);
        }
    }
}
