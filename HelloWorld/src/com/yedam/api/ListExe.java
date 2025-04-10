package com.yedam.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListExe {
    public static void main(String[] args) {
        /*
         * List 컬렉션
         * 
         * 배열   : int[], String[], Object[]
         * 컬렉션 : List<Integer>, List<String>, List<Object>
         * 
         * 요소 접근, 할당 방법
         * 배열   : intArr[0], strArr[0], objArr[0]
         * 컬렉션 : intLst.get(0), strLst.add(10) -> 메소드 활용
         * 
         */
        
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(100); // 처음에 100
        intList.add(200); // 다음에 200
        intList.add(150); // 다음에 150
        intList.add(100); // 다음에 100
        
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }
        System.out.println();
        
        /*
         * Set 컬렉션
         * 중복을 허용하지 않음
         * 
         */
        
        Set<Integer> intSet = new HashSet<Integer>();
        intSet.add(100);
        intSet.add(200);
        intSet.add(150);
        intSet.add(50);
        intSet.add(450);
        intSet.add(250);
        intSet.add(25);
        intSet.add(100);
        
        for (Integer num : intSet) {
            System.out.println(num);
        }
        System.out.println();
        
        Set<Member> members = new HashSet<Member>(); // HashSet은 hashCode의 값과 equals의 결과가 모두 일치할 때 중복으로 취급
        members.add(new Member("홍길동", 20));
        members.add(new Member("박태욱", 21));
        members.add(new Member("최선욱", 22));
        members.add(new Member("홍길동", 20));
        
        for (Member member : members) {
            System.out.println(member.toString());
        }
    }
}
