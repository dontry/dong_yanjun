package com.monash.Utils;

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
}
