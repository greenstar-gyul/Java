package com.yedam.variable;

public class VarExe6 {
    public static void test() {
//      // 임의의 1~50 사이의 정수 5개 생성
//      for (int i = 0; i < 5; i++) {
//          // Math.random(); // 0 <= x < 1 실수 생성
//          System.out.println((int) (Math.random() * 50) + 1);
//      }

        // 학생의 점수(30~100 사이의 무작위 정수)를 생성해 배열에 5개 저장
        // 그 중 홀수 점수만 출력
        int[] scores = new int[5];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = (int) (Math.random() * 71) + 30;
            if (scores[i] % 2 == 1) {
                System.out.println(scores[i] + "점");
            }
        }

//      boolean is_100 = false;
//      int count = 0;
//      while(!is_100) {
//          int score = (int) (Math.random() * 71) + 30;
//          count++;
//          
//          if (score == 100) {
//              System.out.println(score + " Count: " + count);
//              is_100 = true;
//          }
//      }

    } // end of test

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        Member m1 = new Member(); // make instances
        m1.setName("김범수");
                
        // System.out.println(m1.score);
        
        Member m2 = new Member(); 
        m2.setName("나얼");
        
        Member m3 = new Member(); 
        m3.setName("박효신");
        
        Member m4 = new Member(); 
        m4.setName("이수");
        
        Member[] members = { m1, m2, m3, m4 };
        
        for (int i = 0; i < members.length; i++) {
          members[i].setScore((int) (Math.random() * 31) + 70);
        }
        
        String search_name = "";
        System.out.print("조회할 사람 입력 >> ");
        search_name = scanner.nextLine();
        for (int i = 0; i < members.length; i++) {
            if (members[i].getName().equals(search_name)) {
                System.out.println(search_name + "의 점수: " + members[i].getScore());
                break;
            }
        }

//        int max_score = -1;
//        int max_idx = -1;
//        for (int i = 0; i < members.length; i++) {
//            members[i].score = (int) (Math.random() * 31) + 70;
//            if (max_score < members[i].score) {
//                max_score = members[i].score;
//                max_idx = i;
//            }
//        }
//        
//        System.out.println("점수가 가장 높은 사람의 이름: " + members[max_idx].name + ", 점수: " + members[max_idx].score);
        
        scanner.close();
        
        
    } // end of main
}
