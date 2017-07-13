package com.openmind.hacadaptor.sqlutil;

import java.lang.annotation.*;

/**
 * @author LiuBin
 * @version Created on 2017/7/10
 */
@Target(ElementType.FIELD)
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PK {
    String value() default "id";
}
