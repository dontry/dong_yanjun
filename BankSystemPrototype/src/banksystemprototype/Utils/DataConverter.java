package banksystemprototype.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    
    public static int monthBetweenDates(Date startDate, Date endDate) {
      Calendar startCalendar = new GregorianCalendar();
      startCalendar.setTime(startDate);
      Calendar endCalendar = new GregorianCalendar();
      endCalendar.setTime(endDate);
      
      int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
      int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
      return diffMonth;
    }
      
    public static String charArraysToString(char[] array) {
        String str= "";
        for(int i = 0; i < array.length; ++i) {
            str += array[i];
        }
        return str;
    }
}
