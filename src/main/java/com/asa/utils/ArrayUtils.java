package com.asa.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andrew_asa
 * @date 2018/10/12.
 */
public class ArrayUtils {

    /**
     * array 数组转list
     *
     * @param elements
     * @param <T>
     * @return
     */
    public static <T> List<T> arrayToList(T[] elements) {

        ArrayList<T> result = new ArrayList<T>();
        if (elements != null) {
            for (T elem : elements) {
                result.add(elem);
            }
        }
        return result;
    }


    /**
     * array 数组转list
     *
     * @param elements
     * @param <T>
     * @return
     */
    public static <T> int length(T[] elements) {

        if (elements != null) {
            return elements.length;
        }
        return 0;
    }

    /**
     * 位于第几个位置
     * 找到一个匹配的则进行返回
     * 没有则是-1
     * 调用item.equals进行比较
     *
     * @param items
     * @param item
     * @param <T>
     * @return
     */
    public static <T> int indexOf(T[] items, T item) {

        return indexOf(items, item, 0);
    }

    /**
     * 位于第几个位置
     *
     * @param items
     * @param item
     * @param startIndex
     * @param <T>
     * @return
     */
    public static <T> int indexOf(T[] items, T item, int startIndex) {

        if (items == null) {
            return -1;
        } else {
            if (startIndex < 0) {
                startIndex = 0;
            }
            int index;
            if (item == null) {
                for (index = startIndex; index < items.length; ++index) {
                    if (items[index] == null) {
                        return index;
                    }
                }
            } else {
                for (index = startIndex; index < items.length; ++index) {
                    if (item.equals(items[index])) {
                        return index;
                    }
                }
            }
            return -1;
        }
    }
}
