package com.yedam.api;

public class StringExe {
    public static void main(String[] args) {
        String str = "Hello World  ";
        str = new String("Hello World");
        
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            System.out.println(b);
        }
        
        byte[] bstr = { 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100 };
        String msg = new String(bstr, 6, 5);
        
        System.out.println(msg);
        
        char result = msg.charAt(0);
        System.out.println((int) result);
        
        if (result == 'W') {
            // 문자 비교
        }
        
        int idx = msg.indexOf("o");
        if (idx >= 0) {
            // 문자열의 존재 유무, 위치
            // 없으면 결과는 음수
        }
        
        String[] names = { "홍길동", "홍길승", "김민길", "박홍길" };
        int cnt = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i].indexOf("홍") == 0) {
                cnt++;
            }
        }
        System.out.println("성이 \"홍\"씨인 사람의 수: " + cnt);
        
        System.out.println("Hello World".substring(3, 7));
        
        str = "Hello World  ";
        System.out.println("str = \"Hello World  \"  " + str + "\n" +
                           "str.charAt(0) =>  " + str.charAt(0) + "\n" +
                           "str.equrals(new String(\"Hello World\") =>  " + str.equals("Hello World") + "\n" +
                           "str.indexOf(\"World\") =>  " + str.indexOf("World") + "\n" +
                           "str.length() =>  " + str.length() + "\n" +
                           "str.replace(\"World\", \"Java\") =>  " + str.replace("World", "Java") + "\n" +
                           "str.substring(6) =>  " + str.substring(6) + "\n" +
                           "str.substring(6, 8) =>  " + str.substring(6, 8) + "\n" +
                           "str.toLowerCase() =>  " + str.toLowerCase() + "\n" +
                           "str.toUpperCase() =>  " + str.toUpperCase() + "\n" +
                           "str.trim() =>  " + str.trim()
                           );
    }
}
