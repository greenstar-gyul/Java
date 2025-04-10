package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.bookApp.Book;

public class ListExe {
    public static void main(String[] args) {
        // 배열의 경우 크기가 고정되면,,
        int[] intArr = { 10, 20 };
        int[] intArr2 = new int[5];
        for (int i = 0; i < intArr.length; i++) {
            intArr2[i] = intArr[i];
        }
        intArr2[2] = 30;
        
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);          // 추가
        intList.add(20);
        intList.add(30);
        
        int it1 = intList.get(0); // 조회
        
        intList.remove(0);        // 삭제
        
        intList.set(0, 30);       // 수정
        
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }
        
        List<String> list2 = new ArrayList<String>();
        list2.add("Hello");
//        list2.add(200);
//        list2.add(new Book());
        
        for (int i = 0; i < list2.size(); i++) {
            String result = list2.get(i);
            System.out.println(result);
        }
        List<Book> list3 = new ArrayList<Book>();
        list3.add(new Book());
    }
}
