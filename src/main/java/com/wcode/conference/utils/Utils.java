package com.wcode.conference.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date createTimeToDate(String time, String timeFormat) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat(timeFormat);
        return dateFormat.parse(time);
    }

}
