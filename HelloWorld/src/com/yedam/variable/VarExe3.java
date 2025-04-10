package com.yedam.variable;

import java.util.Scanner;

// 사용자의 입력값을 읽어들이는
// Scanner 클래스.
public class VarExe3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.print("이름을 입력하세요>> ");
        String name = scn.nextLine(); // 문자열

        System.out.print("점수를 입력하세요>> ");
        int score = scn.nextInt(); // 정수
        
        System.out.print("키를 입력하세요>> ");
        double height = scn.nextDouble(); // 정수
        
        System.out.println(
                        "<입력한 값> (⩌⩊⩌)" + 
                        "\n이름 \t " + name +
                        "\n점수 \t " + score +
                        "\n키 \t " + height
                        );
        
        scn.close();
    }
}
