package com.yedam.inheritance;

/*
 * 추상 클래스를 상속받았다면
 * 부모 클래스의 추상 메소드를 반드시 overriding 해야함
 */

public class Bird extends Animal {
    @Override
    void sound() {
        System.out.println("짹짹");
    }
}
