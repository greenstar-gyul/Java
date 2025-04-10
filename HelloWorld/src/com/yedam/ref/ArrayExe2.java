package com.yedam.ref;

import com.yedam.variable.Member;

public class ArrayExe2 {
    public static void main(String[] args) {
        String[] strArr = { "Hello", "World", "20", "23.4" };
        
//        for (String str : strArr) {
//            System.out.println(str);
//        }
        
        strArr = new String[10]; // { null, null, null, ..., null }
        strArr[0] = "Nice";
        
//        for (String str : strArr) {
//            System.out.println(str);
//        }
        
        Member[] memArr = new Member[10]; // { null, null, null, ..., null }
        memArr[0] = new Member("ㅁ", 0);
        memArr[0].setMember("띨띨이", 17);
        memArr[0].setScore(-19);
        // memArr[0].showInfo();
        
        memArr[1] = new Member();
        memArr[1].setMember("빵빵이", 21);
        memArr[1].setScore(200);
        // memArr[1].showInfo();
        
        memArr[2] = new Member("똘똘이", 96);
        // memArr[2].showInfo();
        
        memArr[3] = new Member("똑똑이", 100);
        // memArr[3].showInfo();
        
        for (Member m : memArr) {
            if (m != null) m.showInfo();
        }
    }
}
