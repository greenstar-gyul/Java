package com.yedam.variable;

public class VarExe7 {
    private static boolean isDuplicate(String name, Member[] storage) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].getName().equals(name))
                return true;
        }
        
        return false;
    }
    
    private static int findIdx(String name, Member[] storage) {
        int idx = -1;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].getName().equals(name)) {
                idx = i;
                break;
            }
        }
        
        return idx;
    }
    
    // 추가, 수정, 삭제, 목록 출력.
    public static void main(String[] args) {
        // nextInt 메소드는 개행문자 이전까지의 숫자를 받아옴.
        // nextLine 메소드를 호출하면 이전의 개행문자로 인해 값을 받아오지 못 함.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean run = true;
        Member[] storage = new Member[100]; // { null, null, ..., null }
        
        storage[0] = new Member("홍길동", 83);
        storage[1] = new Member("김민혁", 86);
        storage[2] = new Member("한수아", 90);

        int menu = -1;          // 메뉴 번호
        int score = -1;         // 등록, 수정에 사용할 점수
        int sum = 0;            // 등록된 사람의 점수 합
        int find_idx = -1;      // 수정, 삭제에 사용될 index
        
        String name = "";       // 등록, 검색에 사용될 이름
        
        double avg = 0.0;       // 평균
        
        int last_idx = 2;       // 현재 마지막 사람이 등록된 index
        int storageSize = 3;    // 현재 등록된 사람의 수
        
        for (int i = 0; i < storageSize; i++)
            sum += storage[i].getScore();
        
        while (run) {
            System.out.println("\n┌───────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("\n│\t 1.등록 \t 2. 수정 \t 3. 삭제 \t 4.출력 \t  5.평균 \t 6. 종료 \t│");
            System.out.println("\n└───────────────────────────────────────────────────────────────────────────────────────────────────────┘");
            
            try {
            System.out.print("번호 입력 >> ");
            menu = Integer.parseInt(scanner.nextLine());
            }
            catch (java.lang.NumberFormatException e) {
                // TODO: handle exception
                System.out.println("잘못된 값이 입력되었습니다.");
            }
            
            switch (menu) {
            case 1:
                // 입력된 이름, 점수 저장
                System.out.print("\n이름을 입력하세요. >> ");
                name = scanner.nextLine();
                
                if (isDuplicate(name, storage)) {
                    System.out.println("이미 등록된 사람입니다.");
                    break;
                }

                System.out.print("\n점수를 입력하세요. >> ");
                score = Integer.parseInt(scanner.nextLine());

                Member member = new Member(name, score);
                
                storage[++last_idx] = member;
                storageSize++;
                
                sum += member.getScore();
                
                System.out.println("\n등록 완료.");

                break;
            case 2:
                // 수정할 사람 찾아서 점수 수정
                System.out.print("\n수정할 사람의 이름을 입력하세요. >> ");
                name = scanner.nextLine();
                
                find_idx = findIdx(name, storage);
                
                if (find_idx == -1) {
                    System.out.println("\n저장되지 않은 사람입니다.");
                    break;
                }
                
                System.out.println("\n점수를 입력하세요. >> ");
                score = Integer.parseInt(scanner.nextLine());
                
                sum -= storage[find_idx].getScore();
                storage[find_idx].setScore(score);
                sum += storage[find_idx].getScore();
                
                System.out.println("수정 완료");
                
                break;
            case 3:
                // 삭제
                System.out.print("\n삭제할 사람의 이름을 입력하세요. >> ");
                name = scanner.nextLine();
                
                find_idx = findIdx(name, storage);
                
                if (find_idx == -1) {
                    System.out.println("\n저장되지 않은 사람입니다.");
                    break;
                }
                
                sum -= storage[find_idx].getScore();
                
                storage[find_idx] = null;

                // 삭제하고 값을 한칸씩 당기기
                for (int i = find_idx; i < storageSize - 1; i++) {
                    storage[i] = storage[i + 1];
                }
                
                storageSize--;
                last_idx--;

                break;
            case 4:
                if (storageSize == 0) {
                    System.out.println("현재 등록된 사람이 없습니다.");
                    break;
                }
                
                for (int i = 0; i < storageSize; i++) {
                    if (storage[i] != null) {
                        storage[i].showInfo();
                    }
                }

                break;
            case 5:
                if (storageSize == 0) {
                    System.out.println("현재 등록된 사람이 없습니다.");
                    break;
                }
                
                avg = (double) sum / storageSize;
                System.out.println("등록된 사람들의 평균 점수는 " + avg + "점 입니다.");
                
                break;
            case 6:
                run = false;
                System.out.println("\n종료");
                break;
            default:
                System.out.println("\n다시 입력해주세요.");
            }
        }
        System.out.print("End of prog");
        scanner.close();
    } // End of main
}
