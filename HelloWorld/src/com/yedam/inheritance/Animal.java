package com.yedam.inheritance;

/*
 * 추상 클래스
 * 추상 메소드는 선언 부분만 존재
 * abstract 키워드 이용
 * C++의 virtual 키워드
 */
public abstract class Animal {
    // 추상 메소드
    abstract void sound();
    
    void eat() {
        System.out.println("냠냠");
    }
}
