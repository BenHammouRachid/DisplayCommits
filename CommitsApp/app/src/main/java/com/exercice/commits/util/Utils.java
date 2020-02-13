package com.exercice.commits.util;

import java.text.SimpleDateFormat;

public class Utils {


    //convert date to string
    public static String getDateString(long longDate) {

        java.util.Date date = new java.util.Date(longDate * 1000);
        SimpleDateFormat date_format = new SimpleDateFormat("MMM dd - yy");
        String dateText = date_format.format(date);

        return dateText;
    }


}
