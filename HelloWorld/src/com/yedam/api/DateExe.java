package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(today.toString());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(today));
        
        try {
            Date tday = sdf.parse("1900-01-01 00:00:00");
            System.out.println(tday.toString());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
