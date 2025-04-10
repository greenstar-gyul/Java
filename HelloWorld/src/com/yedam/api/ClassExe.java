package com.yedam.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExe {
    public static void main(String[] args) {
        try {
            Class cls = Class.forName("com.yedam.bookApp.Book");
            
            // 클래스의 메소드
            Method[] methods = cls.getDeclaredMethods();
            for (Method method: methods) {
                System.out.println(method.getName());
            }
            
            // 클래스의 생성자
            Constructor[] cons = cls.getDeclaredConstructors();
            for (Constructor c : cons) {
                System.out.println(c.getName());
            }
            
            // 클래스의 필드 반환
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f.getName());
            }
            
        } catch (ClassNotFoundException e) {  // ClassNotFoundException => 일반 Exception 예외를 상속받아서 예외처리 필수
            e.printStackTrace();
        }
    }
}
