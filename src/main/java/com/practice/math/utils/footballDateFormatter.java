package com.practice.math.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FootballDateFormatter {

    public Date convertToDate(String receivedDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(receivedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String convertToString(Date receivedDate) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(receivedDate);
    }
}
