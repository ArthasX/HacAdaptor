package com.openmind.hacadaptor.socket.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by LiuBin on 2017/7/4.
 */
public class ClassUtil {
    /**
     * To get the parameterized types of one class from its superclass.<p>
     * e.g. Class A &lt T1,T2... &gt extends B &lt T1,T2... &gt
     *
     * @param clazz A.class
     * @param index The index of paramterized the types.<P>
     *              index may by 1,2,3...
     * @return the class of T[index]
     */
    public static Class<Object> getSuperClassGenricType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType))
            return Object.class;
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0)
            return Object.class;
        if (!(params[index] instanceof Class))
            return Object.class;
        return (Class) params[index];
    }

}
