package com.yedam.ref;

public class ArrayExe3Calendar {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    public static final int TEST = 21;
    
    private static String formatting(int i) {
        if (i < 10) {
            return "  " + i + " ";
        }
        return " " + i + " ";
    }
    
    // 2025년 기준, 입력한 월의 1일이 무슨 요일에 있는지 반환
    public static int getFirstDay(int month) {
        switch(month) {
        case 1:
            return 3;
        case 2:
            return 6;
        case 3:
            return 6;
        case 4:
            return 2;
        case 5:
            return 4;
        case 6:
            return 0;
        case 7:
            return 2;
        case 8:
            return 5;
        case 9:
            return 1;
        case 10:
            return 3;
        case 11:
            return 6;
        case 12:
            return 1;
        }
        
        return 1;
    }
    
    public static int getLastDate(int month) {
        if (month == 2) {
            return 28;
        }
        if (month > 7) {
            if (month % 2 == 0) {
                return 31;
            }
            else {
                return 30;
            }
        }
        else {
            if (month % 2 == 1) {
                return 31;
            }
            else {
                return 30;
            }
        }
    }
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String[] days = { ANSI_RED + "Sun", ANSI_BLACK + "Mod", ANSI_BLACK + "Tue", ANSI_BLACK + "Wed",
                ANSI_BLACK + "Thu", ANSI_BLACK + "Fri", ANSI_BLUE + "Sat" };
        
        int month = 3;
        int space = getFirstDay(month);    // 날짜 첫주 공백 일수
        int dateNum = getLastDate(month); // 해당 월은 몇일까지 있는지
        
        for (String d : days)
            System.out.print(ANSI_WHITE_BACKGROUND + d + " " + ANSI_RESET);
        System.out.println();
        for (int i = 0; i < space; i++)
            System.out.print(ANSI_BLACK + ANSI_WHITE_BACKGROUND + "    " + ANSI_RESET);
        
        for (int i = 1; i <= dateNum; i++) {
            if (i == TEST && month == 3) {
                System.out.print(ANSI_PURPLE + ANSI_WHITE_BACKGROUND + "시험" + ANSI_RESET);
            }
            else {
                if ((space + i) % 7 == 0) {
                    System.out.println(ANSI_BLUE + ANSI_WHITE_BACKGROUND + formatting(i) + ANSI_RESET);
                }
                else if ((space + i) % 7 == 1){
                    System.out.print(ANSI_RED + ANSI_WHITE_BACKGROUND + formatting(i) + ANSI_RESET);
                }
                else {
                    System.out.print(ANSI_BLACK + ANSI_WHITE_BACKGROUND + formatting(i) + ANSI_RESET);
                }
            }
        }
        
        for (int i = 0; i < 7 - (space + dateNum) % 7; i++) {
            System.out.print(ANSI_BLACK + ANSI_WHITE_BACKGROUND + "    " + ANSI_RESET);
        }
        
        scanner.close();
        System.out.println("\nExit Programs");
    } // end of main

}
