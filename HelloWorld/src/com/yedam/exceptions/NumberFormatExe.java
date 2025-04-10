package com.yedam.exceptions;

import java.util.Scanner;

public class NumberFormatExe {
    public static void main(String[] args) {
        try {
            exceptMethod();
        } 
        catch(NumberFormatException e) {
            System.out.println("Throw된 예외");
        } 
        finally {
            System.out.println("정상적인 실행 or 예외 실행 상관 없이 실행되는 부분");
        }
        System.out.println("end of program");
    }

    // 예외 떠넘기기
    // 메소드 실행 중 throws 에 대한 예외가 발생시, 해당 예외를 호출 지점으로 넘겨줌
    // 메소드 내에서 처리되지 않은 예외를 호출부로 넘겨줌
    static void exceptMethod() throws NumberFormatException {
        Scanner scn = new Scanner(System.in);
        System.out.print("정수 입력 >> ");
        String strNo = scn.nextLine();
        
        int no = 1;
//        try {
        no = Integer.parseInt(strNo);
//        }
//        catch (NumberFormatException e) {
        System.out.println("strNo is not number");
//        }
        System.out.println(no);
    }
}
