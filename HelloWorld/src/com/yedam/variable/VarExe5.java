package com.yedam.variable;

// 예금, 출금, 잔고 확인
public class VarExe5 {
    public static void main(String[] args) {
        boolean run = true;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        int balance = 0; // 예금액
        
        // 최대 예금액은 10만원이고, 마이너스 통장은 없음
        while(run) {
            int menu = 0;
            int buf_bal = 0;
            
            System.out.println("1. 예금 \t 2. 출금 \t 3. 잔고 \t 4. 종료");
            menu = scanner.nextInt();
            
            switch(menu) {
            case 1:
                System.out.println("얼마를 넣을까요?");
                buf_bal = scanner.nextInt();
                
                if (balance + buf_bal > 100000)
                    System.out.println("예금액은 10만원을 넘어설 수 없습니다.");
                else
                    balance += buf_bal;
                
                break;
            case 2:
                System.out.println("얼마를 꺼낼까요?");
                buf_bal = scanner.nextInt();
                
                if (balance - buf_bal < 0)
                    System.out.println("잔고가 부족합니다.");
                else
                    balance -= buf_bal;
                
                break;
            case 3:
                System.out.println("현재 잔고는 " + balance + "원입니다.");
                break;
            case 4:
                System.out.println("이용해주셔서 감사합니다.");
                run = false;
                break;
            default:
                System.out.println("다시 입력하세요.");
                break;
            }
            
            System.out.println();
        }
        
        System.out.println("end of programs");
        
        scanner.close();
        
    } // end of main
}
