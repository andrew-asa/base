package com.asa.base.utils;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author andrew_asa
 * @date 2019/3/18.
 */
public class ClassUtilsTest {

    @Test
    public void getInterfaces() throws Exception {

        //List<Class<?>> clazz = ClassUtils.getAllInterfaces(String.class);
        //System.out.println(clazz);
        InvocationHandler ph = new Ph(new SimpleValue() {

            @Override
            public String echo(String s) {

                return s;
            }
        });
        SimpleValue c = (SimpleValue) Proxy.newProxyInstance(SimpleValue.class.getClassLoader(),
                                                             new Class[]{SimpleValue.class},
                                                             ph);
        c.echo("hello");
    }

    class Ph implements InvocationHandler {

        private Object target;

        public Ph(Object target) {

            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println(StringUtils.messageFormat("invoke method: {}", method));
            System.out.println(StringUtils.messageFormat("invoke args : {}", args));
            return method.invoke(target, args);
        }
    }


}