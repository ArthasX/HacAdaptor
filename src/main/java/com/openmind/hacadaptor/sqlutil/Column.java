package com.openmind.hacadaptor.sqlutil;

import java.lang.annotation.*;

/**
 * Created by KJB-001064 on 2017/6/22.
 */
@Target(ElementType.FIELD)
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    //public String name() default "fieldName";

    public boolean required() default true;

    public String value();
}
