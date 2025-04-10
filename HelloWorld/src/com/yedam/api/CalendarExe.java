package com.yedam.api;

import java.util.Calendar;

public class CalendarExe {
    static Calendar cal = Calendar.getInstance();

    // 년, 월을 입력하면 그 달 1일의 
    // 1. 요일 정보
    static String getDay(int year, int month) {
        cal.set(year, month - 1, 1);        
        
        int day = cal.get(Calendar.DAY_OF_WEEK);
        
        switch (day) {
        case Calendar.SUNDAY:
            return "일요일";
        case Calendar.MONDAY:
            return "월요일";
        case Calendar.TUESDAY:
            return "화요일";
        case Calendar.WEDNESDAY:
            return "수요일";
        case Calendar.THURSDAY:
            return "목요일";
        case Calendar.FRIDAY:
            return "금요일";
        case Calendar.SATURDAY:
            return "토요일";
        }
        
        return "혹시 외계인?";
    }
    
    // 2. 말일(28, 29, 30, 31) 뭔지
    static int getLastDate(int year, int month) {
        cal.set(year, month - 1, 1);
        
        return cal.getActualMaximum(Calendar.DATE);
    }
    
    public static void main(String[] args) {
        cal.set(Calendar.YEAR, 2112);
        cal.set(Calendar.MONTH, 8);
        cal.set(Calendar.DATE, 3);
        
        cal.set(2012, 11, 31);
        
        System.out.println(cal.get(Calendar.YEAR) + "년");
        System.out.println(cal.get(Calendar.MONTH) + 1 + "월");
        System.out.println(cal.get(Calendar.DATE) + "일");
        System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 요일
        System.out.println(cal.getActualMaximum(Calendar.DATE)); // 마지막 날
        
        System.out.println("2024년 12월 1일의 요일: " + getDay(2024, 12));
        System.out.println("2504년 2월은 마지막 날이 " + getLastDate(2504, 2) + "일");
    }
}
