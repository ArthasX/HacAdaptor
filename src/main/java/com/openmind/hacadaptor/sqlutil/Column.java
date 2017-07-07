package com.openmind.hacadaptor.sqlutil;

import java.lang.annotation.*;

/**
 * Created by LiuBin on 2017/6/22.
 */
@Target(ElementType.FIELD)
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    //public String name() default "fieldName";

    boolean required() default true;

    String value();
}
