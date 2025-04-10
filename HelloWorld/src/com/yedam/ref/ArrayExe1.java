package com.yedam.ref;

public class ArrayExe1 {
    public static void main(String[] args) {
        int[] intArr = { 10, 20, 30 };
        
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
        
        intArr = new int[] { 40, 50, 60 };
        
        intArr = new int[10];
        intArr[3] = 30;
        intArr[9] = 90;
        
        // intArr[10] = 100; // 예외 발생
        
        intArr[1] = 100;
        
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] == 0)
                intArr[i] = (int) (Math.random() * 100) + 1;
        }
        
        System.out.println("==============(⩌⩊⩌)==================");
        int sum = 0;
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(i + "번째 값: " + intArr[i]);
            if (intArr[i] % 2 == 1) {
                sum += intArr[i];
            }
        }
        System.out.println("홀수의 합은 " + sum);
        
    }
}
