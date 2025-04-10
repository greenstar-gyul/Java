package com.yedam.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectExe2 {
    public static void main(String[] args) {
        Object obj1 = new Object();
        System.out.println(obj1.toString()); // toString 메소드 생략가능
        
        Date obj2 = new Date();
        System.out.println(obj2.toString());
        
        // 2025년 03월 17일 13시 23분 45초 형식으로 출력하기
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(obj2));
    }
}
