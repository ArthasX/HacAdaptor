package com.openmind.hacadaptor.sqlutil;

import java.lang.annotation.*;

/**
 * Created by KJB-001064 on 2017/6/22.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Table {
    String value();
}
