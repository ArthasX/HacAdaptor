package com.openmind.hacadaptor.socket.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by KJB-001064 on 2017/7/4.
 */
public class ClassUtil {
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
