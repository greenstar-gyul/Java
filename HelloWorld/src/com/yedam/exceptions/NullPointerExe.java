package com.yedam.exceptions;

public class NullPointerExe {
    public static void main(String[] args) {
        String str = null;
        int[] intArr = { 10, 20 };
        
        try {
            System.out.println(str.toString());
        }
        catch(NullPointerException e) {
            System.out.println("\"str\" is null");
        }
        
        try {
            intArr[2] = 30;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }
        
        System.out.println("end of program");
    }
}
