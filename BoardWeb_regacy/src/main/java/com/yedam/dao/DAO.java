package com.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String USER_ID = "scott";
    public static final String USER_PW = "tiger";
    
    protected Connection getConnect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(DB_URL, USER_ID, USER_PW);
            System.out.println("연결 됨");
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return null;
    }
}
