package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class ListSetExe {
    
    public static void main(String[] args) {
        Integer[] iAry = { 10, 20, 30 };
        for (int i = 0; i < iAry.length; i++) {
            System.out.println(iAry[i]);
        }
        
        List<Integer> iList = new ArrayList<>();
        iList.add(10);
        iList.add(20);
        iList.add(30);
        for (int i = 0; i < iList.size(); i++) {
            System.out.println(iList.get(i));
        }
        
    }
}
