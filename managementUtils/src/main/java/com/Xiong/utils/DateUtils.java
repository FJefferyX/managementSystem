package com.Xiong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String dateToString(Date date, String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static Date stringToDate(String string, String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        Date parse = simpleDateFormat.parse(date);
        return parse;
    }
}
