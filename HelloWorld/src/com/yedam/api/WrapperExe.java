package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

public class WrapperExe {
    public static void main(String[] args) {
        int[] intArr = { 10, 20 };
        List<Integer> list = new ArrayList<Integer>();
        
        list.add(10); // int -> Integer : 박싱, Integer -> int : 언박싱
        
        int num1 = 10000;
        Integer num2 = new Integer(10000);
        Integer num3 = new Integer(10000);
        
        System.out.println(num3.intValue() == num2);
    }
}
