package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. ojdbc 데이터베이스 연결, 쿼리, 실행
 * 2. Connection 객체로 데이터베이스 세션 연결
 * 3. Statement(or PreparedStatement) 객체로 쿼리 실행
 * 4. ResultSet: 조회 결과, 
 */

public class DaoExe {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userId = "scott";
        String userPw = "tiger";
        String sql = "SELECT   empno, ename, job, mgr, hiredate, sal "
                   + "FROM     emp "
                   + "ORDER BY empno DESC";
        String insert = "INSERT INTO emp (empno, ename, job, mgr, hiredate, sal) "
                      + "VALUES          (9998, '홍길동', 'CLERK', 7788, '2020-01-01', 1000)";
        String delete = "DELETE FROM emp "
                      + "WHERE       empno = 9999";

        try {
            Connection conn = DriverManager.getConnection(url, userId, userPw);
            System.out.println("연결 성공");
            
            conn.setAutoCommit(false); // use auto commit (default: true)
            
            Statement stmt = conn.createStatement();
            
            int r = stmt.executeUpdate(delete); // 변경 or 삭제된 행 수 반환
            if (r > 0) {
                System.out.println("삭제 성공");
                conn.commit(); // commit
            }
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getInt("empno") + ", " + rs.getString("ename") + ", " + rs.getString("job"));
            }
            System.out.println("-- end of data --");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
