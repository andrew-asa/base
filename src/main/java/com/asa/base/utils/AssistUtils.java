package com.asa.base.utils;




public class AssistUtils {

    //private static final ToStringStyle EMB_TO_STRING_STYLE = new FineToStringStyle();
    private static final float FLOAT_DELTA = 1e-6f;
    private static final double DOUBLE_DELTA = 1e-10;

    //static {
    //    ReflectionToStringBuilder.setDefaultStyle(EMB_TO_STRING_STYLE);
    //}

    /**
     * 判断 double 类型是否相等。
     * <p>
     * 浮点数采用“尾数+阶码”的编码方式，类似于科学计数法的“有效数字+指数”的表示方式。
     * 二进制无法精确表示大部分的十进制小数。
     * <p>
     * 这里首先比较该数二进制是否相等，若不相等则采用近视精度比较，精度可自定义。
     *
     * @param d1    双精度浮点
     * @param d2    双精度浮点
     * @param delta 判断精度
     * @return 是否相等
     * @see #equals(double, double)
     */
    public static boolean equalsDouble(double d1, double d2, double delta) {
        if (Double.compare(d1, d2) == 0) {
            return true;
        }
        return Math.abs(d1 - d2) <= delta;
    }

    /**
     * 判断 float 类型是否相等。
     * <p>
     * 浮点数采用“尾数+阶码”的编码方式，类似于科学计数法的“有效数字+指数”的表示方式。
     * 二进制无法精确表示大部分的十进制小数。
     * <p>
     * 这里首先比较该数二进制是否相等，若不相等则采用近视精度比较，精度可自定义。
     *
     * @param f1    单精度浮点
     * @param f2    单精度浮点
     * @param delta 判断精度
     * @return 是否相等
     * @see #equals(float, float)
     */
    public static boolean equalsFloat(float f1, float f2, float delta) {
        if (Float.compare(f1, f2) == 0) {
            return true;
        }
        return Math.abs(f1 - f2) <= delta;
    }

    /**
     * 判断 double 类型是否相等，精度默认为 1e-10。
     *
     * @param d1 双精度浮点
     * @param d2 双精度浮点
     * @return 是否相等
     * @see #equalsDouble(double, double, double)
     */
    public static boolean equals(double d1, double d2) {
        return equalsDouble(d1, d2, DOUBLE_DELTA);
    }

    /**
     * 判断 float 类型是否相等，精度默认为 1e-6。
     *
     * @param f1 单精度浮点
     * @param f2 单精度浮点
     * @return 是否相等
     * @see #equalsFloat(float, float, float)
     */
    public static boolean equals(float f1, float f2) {
        return equalsFloat(f1, f2, FLOAT_DELTA);
    }

    /**
     * 判断两个对象是否相等
     *
     * @param source 对象1
     * @param des    对象2
     * @return 如果两个对象相等，则返回true，否则返回false
     */
    public static boolean equals(Object source, Object des) {

        if (source == null && des == null) {
            return true;
        }
        if (source == null) {
            return false;
        }
        if (des == null) {
            return false;
        }
        return source.equals(des);
    }

    /**
     * 比较基本类型的大小，处理溢出情况，与Comparator配合
     *
     * @param i 第一个数
     * @param j 第二个数
     * @return 是否 i > j
     */
    public static int compare(int i, int j) {

        if (i == j) {
            return 0;
        }
        return i > j ? 1 : -1;
    }


    /**
     * 返回多个属性合并计算的哈希值
     *
     * @param args 对象列表
     * @return 哈希值
     */
    //public static int hashCode(Object... args) {
    //
    //    return com.fr.third.guava.base.Objects.hashCode(args);
    //}

    /**
     * 不允许为null的判断
     *
     * @param obj 对象
     * @param <T> 类型
     * @return 如果对象为null，则抛出异常，否则就返回对象本身
     */
    public static <T> T requireNonNull(T obj) {

        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    /**
     * 对象的的toString方法
     *
     * @param target 对象
     * @return 文本
     */
    //public static String toString(Object target) {
    //
    //    return ToStringBuilder.reflectionToString(target, EMB_TO_STRING_STYLE);
    //}

    /**
     * 对象的的toString方法
     *
     * @param target   对象
     * @param excludes 要排除掉的属性名
     * @return 文本
     */
    //public static String toString(Object target, String... excludes) {
    //
    //    return ReflectionToStringBuilder.toStringExclude(target, excludes);
    //}

    //private static final class FineToStringStyle extends ToStringStyle {
    //
    //    private static final long serialVersionUID = 1L;
    //
    //    FineToStringStyle() {
    //
    //        super();
    //        this.setContentStart("[");
    //        this.setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
    //        this.setFieldSeparatorAtStart(true);
    //        this.setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
    //        this.setUseShortClassName(true);
    //        this.setUseIdentityHashCode(false);
    //    }
    //
    //    private Object readResolve() {
    //
    //        return AssistUtils.EMB_TO_STRING_STYLE;
    //    }
    //}
}
