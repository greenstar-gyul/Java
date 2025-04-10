package com.yedam.bookApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberJdbc {

    // Connection 생성
    Connection getConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userId = "scott";
        String userPw = "tiger";

        try {
            Connection conn = DriverManager.getConnection(url, userId, userPw);
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Map<String, String>> memberList() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        String sql = "SELECT user_id, password, user_name " //
                   + "FROM   tbl_member";

        Connection conn = getConnection();
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("userId", rs.getString("user_id"));
                map.put("userPw", rs.getString("password"));
                map.put("userName", rs.getString("user_name"));
                list.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public String login(String id, String pw) {
        String sql = "SELECT user_name "
                   + "FROM   tbl_member "
                   + "WHERE  user_id = ? "
                   + "  AND  password = ?";
        Connection conn = getConnection();
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.setString(2, pw);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                return rs.getString("user_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        
//        List<Map<String, String>> list = memberList();
//        
//        for (Map<String, String> user : list) {
//            if (user.get("userId").equals(id) && user.get("userPw").equals(pw)) {
//                    System.out.println("\n" + user.get("userName") + "님 환영합니다.\n");
//                    return true;
//            }
//        }
        
        return null;
    }
}
