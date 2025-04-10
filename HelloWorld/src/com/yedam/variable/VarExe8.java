package com.yedam.variable;

public class VarExe8 {
    public static void main(String[] args) {
        int n1 = 10;
        byte b1 = 120;
        byte result = (byte) (b1 + 150); // casting
        
        System.out.println("더한 결과" + result);
        
        n1 = b1;
        System.out.println(n1);
        
        n1 = 200;
        b1 = (byte) n1;
        System.out.println(b1);
        
        for (int i = 1; i <= 15; i++) {
            System.out.println(++b1);
        }
    }
}
