package com.yedam.variable;

class Student {
    String name;
    int score;
    double height;
}

public class VarExe2 {
    public static void main(String[] args) {
        String name = "ㅎㄷㅇ";
        int score = 100;

        Student s1 = new Student(); // make instances
        s1.name = "hdu";
        s1.score = 200;
        s1.height = 172.3;

        Student s2 = new Student(); // make instances
        s2.name = "jtn";
        s2.score = 150;
        s2.height = 162.8;

        /*****************************************************/

        int[] scores = { 89, 77, 69, score };
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        System.out.println("합: " + sum);

        String[] names = { "강", "김", name };

        for (int i = 0; i < names.length; i++) {
            System.out.println("이름==> " + names[i]);
        }

        Student[] students = { s1, s2 };

        for (int i = 0; i < students.length; i++) {
            System.out.println(
                "이름: " + students[i].name + 
                ", 점수: " + students[i].score + 
                ", 키: " + students[i].height + 
                " (⩌⩊⩌)");
        }
    }
}
