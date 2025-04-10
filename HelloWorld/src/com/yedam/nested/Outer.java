package com.yedam.nested;

public class Outer {
    class Inner {
        String name;
        void innerMethod() {
            System.out.println("Call Methods");
        }
    }
    
    void method1() {
        Inner inner = new Inner();
        inner.name = "홍길동";        
        System.out.println(inner.name);
    }
    
}
