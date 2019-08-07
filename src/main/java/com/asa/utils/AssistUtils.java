//package com.asa.utils;
//
//import com.asa.third.org.apache.commons.lang3.SystemUtils;
//import com.asa.third.org.apache.commons.lang3.builder.ReflectionToStringBuilder;
//import com.asa.third.org.apache.commons.lang3.builder.ToStringBuilder;
//import com.asa.third.org.apache.commons.lang3.builder.ToStringStyle;
//
//import java.util.Objects;
//
///**
// * @author andrew_asa
// * @date 2018/10/15.
// */
//public class AssistUtils {
//
//    private static final ToStringStyle EMB_TO_STRING_STYLE = new DefaultStringStyle();
//
//    public AssistUtils() {
//
//    }
//
//    public static boolean equals(Object var0, Object var1) {
//
//        return var0 == null && var1 == null ? true : (var0 == null ? false : (var1 == null ? false : var0.equals(var1)));
//    }
//
//
//    public static int hashCode(Object... values) {
//
//        return Objects.hashCode(values);
//    }
//
//    public static String toString(Object value) {
//
//        return ToStringBuilder.reflectionToString(value, EMB_TO_STRING_STYLE);
//    }
//
//    public static String toString(Object obj, String... elements) {
//
//        return ReflectionToStringBuilder.toStringExclude(obj, elements);
//    }
//
//    static {
//        ReflectionToStringBuilder.setDefaultStyle(EMB_TO_STRING_STYLE);
//    }
//
//    private static final class DefaultStringStyle extends ToStringStyle {
//
//        private static final long serialVersionUID = 1L;
//
//        DefaultStringStyle() {
//
//            this.setContentStart("[");
//            this.setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
//            this.setFieldSeparatorAtStart(true);
//            this.setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
//            this.setUseShortClassName(true);
//            this.setUseIdentityHashCode(false);
//        }
//
//        private Object readResolve() {
//
//            return AssistUtils.EMB_TO_STRING_STYLE;
//        }
//    }
//}
