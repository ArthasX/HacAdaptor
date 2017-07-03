package com.openmind.hacadaptor.mvc;

import com.openmind.hacadaptor.util.ArrayUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by KJB-001064 on 2017/6/23.
 */

public class TestReflect {
    @Test
    public void test(){

        try {
            ArrayUtils arrayUtils = new ArrayUtils();
            Method method = ArrayUtils.class.getMethod("test",String.class);
            method.invoke(arrayUtils,"asdasd");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
