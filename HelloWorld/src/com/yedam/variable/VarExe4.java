package com.yedam.variable;

public class VarExe4 {
    public static void main(String[] args) {
        int[] scores = new int[3]; // { 0, 0, 0 }
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "번째 점수를 입력하세요.>> ");
            scores[i] = scanner.nextInt();
            sum += scores[i];
        }

        double avg = (double) sum / scores.length;
        System.out.println("합은 " + sum + "이고, 평균은" + avg + "입니다.");

        scanner.close();
    }
}
