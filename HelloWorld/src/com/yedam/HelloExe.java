package com.yedam;

class Student {
    private String name;
    private String tel;
    private int age;
    
    Student() { }
    
    Student(String name, String tel, int age) {
        this.name = name;
        this.tel = tel;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class HelloExe {
    public static void main(String[] args) {
        // 1. 32000 변수 선언과 할당
        int num = 32000;
        
        // 2. 34, 32, 88, 23 저장
        int[] nums = { 34, 32, 88, 23 };
        
        // 3. 문자: 32
        String str = "32";
        
        // 4. 문자열 -> 정수
        int stoi = Integer.parseInt(str);
        
        // 5. Hello, Nice, Good 저장
        String[] strs = { "Hello", "Nice", "Good" };
        
        // 6. 60 ~ 100 랜덤 정수 5개 저장
        int[] ranInt = new int[5];
        for (int i = 0; i < ranInt.length; i++) {
            ranInt[i] = (int) (Math.random() * 41) + 60;
        }
        
        new Student();
        
        // 7. 이름, 연락처, 나이 저장
        Student s = new Student("홍길동", "010-1234-5678", 20);
        
        // 8. 7에서 만든 클래스 배열
        Student[] students = {
                new Student("홍길동", "010-1234-5678", 20),
                new Student("김민식", "010-2222-2222", 22),
                new Student("최문식", "010-3333-3333", 23)
        };
        
        // 9. 8에서 만든 배열에서 나이가 가장 많은 사람의 이름
        int maxAge = 0, idx = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getAge() > maxAge) {
                maxAge = students[i].getAge();
                idx = i;
            }
        }
        System.out.println(students[idx].getName());
    }
}
