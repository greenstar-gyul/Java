package com.yedam.api;

class Member {
    String name;
    int age;
    
    public Member() { }
    
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member new_member = (Member) obj;
            
            return this.name.equals(new_member.name) &&
                   this.age == new_member.age;
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return "이름: " + name + ", 나이: " + age;
    } 
    
    @Override
    public int hashCode() {
        return age;
    }
}


public class ObjectExe1 {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        // 비교 메소드 equals
        System.out.println(obj1 == obj2);       // 메모리 주소 비교
        System.out.println(obj1.equals(obj2));  // 
        
//        String str1 = "홍길동";
//        String str2 = new String("홍길동");
//        
//        System.out.println(str1 == str2);
//        System.out.println(str1.equals(str2));
        
        Member m1 = new Member();
        Member m2 = new Member();
        
        m1.name = "홍길동";
        m2.name = "홍길동";
        
        m1.age = 20;
        m1.age = 19;
        
        System.out.println(m1 == m2);
        System.out.println(m1.equals(m2));
    }
}
