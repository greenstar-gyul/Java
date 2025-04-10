package com.yedam.api;

public class SystemTimeExample {
    public static void main(String[] args) {
        final int MAX_VALUE = 1000000;

        int sum = 0;
        long time1 = System.nanoTime();
        sum = 0;
        for (int i = 1; i <= MAX_VALUE; i++) {
            sum += i;
        }
        long time2 = System.nanoTime();
        System.out.println("1부터 " + MAX_VALUE + "까지의 합: " + sum + "\n소요 시간: " + (time2 - time1) + "ns");
        
    }
}
