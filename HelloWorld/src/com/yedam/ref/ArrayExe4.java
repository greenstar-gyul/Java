package com.yedam.ref;

public class ArrayExe4 {
    private static final int MAX_SIZE = 100;
    
    // private static int[] intArr = { 8, 2, 9, 6, 7, 3, 5, 4, 1 };
    private static int[] intArr = new int[MAX_SIZE];
    
    
    private static void initialize() {
        boolean[] checkList = new boolean[MAX_SIZE + 1];
        int i = 0;
        int tmp = 0;
        while (i < intArr.length) {
            tmp = (int) (Math.random() * MAX_SIZE) + 1;
            if (!checkList[tmp]) {
                checkList[tmp] = true;
                intArr[i] = tmp;
                i++;
            }
        }
    }
    
    private static void showArrStatus() {
        for (int a : intArr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
    
    private static void bubbleSort() {
        int tmp = 0;
        
//        showArrStatus();
        for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = 1; j < intArr.length; j++) {
                if (intArr[j - 1] > intArr[j]) {
                    tmp = intArr[j];
                    intArr[j] = intArr[j - 1];
                    intArr[j - 1] = tmp;
                }
            }
//            showArrStatus();
        }
    }
    
    private static void selectSort() {
        int min = 0;
        int tmp = 0;
        int idx = 0;
        
//        showArrStatus();
        for (int i = 0; i < intArr.length - 1; i++) {
            min = intArr[i];
            idx = i;
            for (int j = i; j < intArr.length; j++) {
                if (intArr[j] < min) {
                    min = intArr[j];
                    idx = j;
                }
            }
            tmp = intArr[i];
            intArr[i] = min;
            intArr[idx] = tmp;
//            showArrStatus();
        }
    }
    
    private static void insertSort() {
        int tmp = 0;
        int idx = 0;
        
//        showArrStatus();
        for (int i = 1; i < intArr.length; i++) {
            tmp = intArr[i];
            idx = i;
            for (int j = i - 1; j >= 0; j--, idx--) {
                if (intArr[j] > tmp) {
                    intArr[idx] = intArr[j];
                    intArr[j] = tmp;
                }
            }
//            showArrStatus();
        }
    }
    
    private static void mergeSort() {
        mergeSort(0, intArr.length - 1);
//        showArrStatus();
    }
    
    private static void mergeSort(int start, int end) {
        if (start + 1 >= end) {
            partitionSort(start, end);
            return;
        }
        
        int mid = (start + end) / 2;
        
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        partitionSort(start, end);
    }
    
    private static void partitionSort(int start, int end) {
        int[] tmpArr = new int[end - start + 1];
        
        int left = start;
        int mid = (start + end) / 2;
        int right = mid + 1;
        
        int idx = 0;
        while (left <= mid && right <= end) {
            if (intArr[left] < intArr[right]) {
                tmpArr[idx++] = intArr[left++];
            }
            else {
                tmpArr[idx++] = intArr[right++];
            }
        }
        
        // 임시배열에 저장되지 못한 나머지 추가
        if (left <= mid) {
            for (int i = left; i <= mid; i++) {
                tmpArr[idx++] = intArr[i];
            }
        }
        else {
            for (int i = right; i <= end; i++) {
                tmpArr[idx++] = intArr[i];
            }
        }
        
        for (int i = start; i <= end; i++) {
            intArr[i] = tmpArr[i - start];
        }
        
//        showArrStatus();
    }
    
    public static void main(String[] args) {
        initialize();
        
//        showArrStatus();
        
        long beforeTime = System.nanoTime();
        
//        bubbleSort();
//        selectSort();
        insertSort();
//        mergeSort();
        
        long afterTime = System.nanoTime();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("sorting time: " + secDiffTime + "ns");
        
//        showArrStatus();
    }
}
