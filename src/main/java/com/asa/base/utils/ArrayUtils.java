package com.asa.base.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author andrew_asa
 * @date 2018/10/12.
 */
public class ArrayUtils {

    /**
     * An empty immutable {@code boolean} array.
     */
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = {};

    /**
     * An empty immutable {@code Boolean} array.
     */
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code byte} array.
     */
    public static final byte[] EMPTY_BYTE_ARRAY = {};

    /**
     * An empty immutable {@code Byte} array.
     */
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code char} array.
     */
    public static final char[] EMPTY_CHAR_ARRAY = {};

    /**
     * An empty immutable {@code Character} array.
     */
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code Class} array.
     */
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];

    /**
     * An empty immutable {@code double} array.
     */
    public static final double[] EMPTY_DOUBLE_ARRAY = {};

    /**
     * An empty immutable {@code Double} array.
     */
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code Field} array.
     *
     * @since 3.10
     */
    public static final Field[] EMPTY_FIELD_ARRAY = {};

    /**
     * An empty immutable {@code float} array.
     */
    public static final float[] EMPTY_FLOAT_ARRAY = {};

    /**
     * An empty immutable {@code Float} array.
     */
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code int} array.
     */
    public static final int[] EMPTY_INT_ARRAY = {};

    /**
     * An empty immutable {@code Integer} array.
     */
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code long} array.
     */
    public static final long[] EMPTY_LONG_ARRAY = {};

    /**
     * An empty immutable {@code Long} array.
     */
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code Method} array.
     *
     * @since 3.10
     */
    public static final Method[] EMPTY_METHOD_ARRAY = {};

    /**
     * An empty immutable {@code Object} array.
     */
    public static final Object[] EMPTY_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code short} array.
     */
    public static final short[] EMPTY_SHORT_ARRAY = {};

    /**
     * An empty immutable {@code Short} array.
     */
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code String} array.
     */
    public static final String[] EMPTY_STRING_ARRAY = {};

    public static final int INDEX_NOT_FOUND = -1;

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

    public static boolean contains(final Object[] array, final Object objectToFind) {

        return indexOf(array, objectToFind) != INDEX_NOT_FOUND;
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

    /**
     * 数组转迭代器
     *
     * @param elements
     * @param <T>
     * @return
     */
    public static <T> Iterator<T> toIterator(T[] elements) {

        return arrayToList(elements).iterator();
    }


    /**
     * 数组转迭代器
     *
     * @param elements
     * @param <T>
     * @return
     */
    public static <T> Iterator<T> toReverseIterator(T[] elements) {

        List<T> list = arrayToList(elements);
        Collections.reverse(list);
        return list.iterator();
    }

    public static boolean[] subarray(final boolean[] array, int startIndexInclusive, int endIndexExclusive) {

        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }

        final boolean[] subarray = new boolean[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    public static byte[] subarray(final byte[] array, int startIndexInclusive, int endIndexExclusive) {

        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_BYTE_ARRAY;
        }

        final byte[] subarray = new byte[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    /**
     * 判断byte数值是否相等
     * @param array1
     * @param array2
     * @return
     */
    public static boolean isEquals(byte[] array1, byte[] array2) {

        if (array1 == null && array2 == null) {
            return true;
        }
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        int l = array1.length;
        for (int i = 0; i < l; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
