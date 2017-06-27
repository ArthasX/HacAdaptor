package com.openmind.hacadaptor.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by KJB-001064 on 2017/6/22.
 */
public class ArrayUtils {
//    public static<T> T[] addAll(T[] beanFields,T[] superBeanFields){
//        return addAll(beanFields,superBeanFields);
//    }

    public static<T> T[] addAll(T[] first,T[] ...beanFields){
        int length=first.length;
        for(T[] t :beanFields){
            length+=t.length;
        }
        //first[x,x,x,.........length]
        T[] result=Arrays.copyOf(first,length);
        int offset=first.length;
        for(T[] t:beanFields){
            System.arraycopy(t,0,result,offset,t.length);
            offset+=t.length;
        }
        return result;
    }
    public void test(String s){
        System.out.println(s);
    }
}
