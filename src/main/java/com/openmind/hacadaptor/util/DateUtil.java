package com.openmind.hacadaptor.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiuBin
 * @version Created on 2017/7/20
 */
public class DateUtil {
    public static String getYYYMMDD(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       return sdf.format(new Date());
    }
}
