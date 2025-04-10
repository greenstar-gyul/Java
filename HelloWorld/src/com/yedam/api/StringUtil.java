package com.yedam.api;

public class StringUtil {
    // 남 / 여 반환
    static String getGender(String ssn) throws StringIndexOutOfBoundsException {
        String checkSsn = ssn.replace(" ", "");
        checkSsn = checkSsn.replace("-", "");
        
        if (checkSsn.length() != 13)
            return "";
        
        switch (checkSsn.charAt(6)) {
        case '1':
        case '3':
            return "남";
        case '2':
        case '4':
            return "여";
        }
        
        return "";
    }
    
    // 파일명 반환
    static String getFileName(String file) throws StringIndexOutOfBoundsException {
        while (file.indexOf("/") >= 0) {
            file = file.substring(file.indexOf("/") + 1);
        }
        
        return file.substring(0, file.indexOf("."));
    }
    
    // 파일확장자 반환
    static String getExtName(String file) throws StringIndexOutOfBoundsException {
        while (file.indexOf("/") >= 0) {
            file = file.substring(file.indexOf("/") + 1);
        }
        
        return file.substring(file.indexOf(".") + 1);
    }
}
