package com.example.caidong.bsp.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by caidong on 9/05/2017.
 */
public class DataConverter {
    private final static String DATE_FORMAT = "dd-MM-yyyy";
    private final static SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);
    public static String dateToString(Date date) {
       return SDF.format(date);
    }
    public static Object fromjsonToObject(String json, Class tClass) {
        //TODO: json to object
        return new Object();
    }
    public static String fromObjectToJson(Object obj, Class tClass) {
        //TODO: object to json
        return "";
    }
}
