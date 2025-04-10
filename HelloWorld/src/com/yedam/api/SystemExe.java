package com.yedam.api;

public class SystemExe {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
//                break;
                System.out.println("종료합니다.");
                System.exit(0); // JVM을 강제로 종료
            }
        }
        
        System.out.println("end of prog");
    }
}
