package com.openmind.util;

import java.util.Arrays;

/**
 * Created by KJB-001064 on 2017/6/30.
 */
public class ArrayUtil {
    public static<T> T[] addAll(T[] first,T[] ...beanFields){
        int length=first.length;
        for(T[] t :beanFields){
            length+=t.length;
        }
        //first[x,x,x,.........length]
        T[] result= Arrays.copyOf(first,length);
        int offset=first.length;
        for(T[] t:beanFields){
            System.arraycopy(t,0,result,offset,t.length);
            offset+=t.length;
        }
        return result;
    }

}
