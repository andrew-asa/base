package com.asa.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    /**
     * 遍历主要是防止判空的情况
     *
     * @param list
     * @param action
     * @param <T>
     */
    public static <T> void forEach(List<T> list, Consumer<? super T> action) {

        if (ListUtils.isNotEmpty(list)) {
            list.forEach(action);
        }
    }

    /**
     * 过滤
     *
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> filterAsList(List<T> list, Predicate<? super T> predicate) {

        if (ListUtils.isNotEmpty(list)) {
            return list.stream().filter(predicate).collect(Collectors.toList());
        }
        return new ArrayList<T>();
    }
}
