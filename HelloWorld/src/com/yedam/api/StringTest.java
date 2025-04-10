package com.yedam.api;

public class StringTest {
    public static void main(String[] args) {
        String[] ssns = { "970513-2148156",
                          "010318 3714123",
                          "1111113489714",
                          "1234567891234",
                          "1"};
        
        String[] files = {"C:/temp/orange.jpg",
                          "d:/storage/test/grape.jpeg",
                          "d:/img/melon.png",
                          "c:/img/",
                          "d:"};
        
        for (String ssn : ssns) {
            try {
                String gender = StringUtil.getGender(ssn);
                if (gender.isBlank()) {
                    System.err.println("주민번호의 형식이 잘못되었습니다. " + ssn);
                }
                else {
                    System.out.println("성별: " + gender);
                }
            }
            catch (StringIndexOutOfBoundsException e) {
                System.err.println("주민번호의 형식이 잘못되었습니다. " + ssn);
            }
        }
        
        System.out.println("\n─────────────────────────────\n");
        for (String file : files) {
            try {
                System.out.println("파일명: " + StringUtil.getFileName(file));
                System.out.println("확장자: " + StringUtil.getExtName(file));
            }
            catch(StringIndexOutOfBoundsException e) {
                System.err.println("파일 경로 형식이 잘못되었습니다. " + file);
            }
        }
    }
}
