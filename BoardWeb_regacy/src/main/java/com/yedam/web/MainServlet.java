package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

/*
 * Tomcat에서 정한 규칙에 따라 서블릿 작성
 * 1. url 패턴 ex) http://localhost/BoardWeb/welcome
 * 2. Servlet 클래스 생성 (construct -> init() -> service() -> destroy())
 */

public class MainServlet extends HttpServlet {
    public MainServlet() {
        System.out.println("MainServlet() 호출.");
    }
    
    // 서블릿 생명주기
    // 1. init()
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init() 호출. 최초 한 번만 실행됨.");
    }
    
    // 2. service()
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        System.out.println("service() 호출. 호출될 때 마다 실행됨.");
        PrintWriter out = resp.getWriter();
//        BoardDAO dao = new BoardDAO();
//        List<BoardVO> list = dao.boardList();
        
        SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<BoardVO> list = session.selectList("com.yedam.mapper.BoardMapper.selectBoard");
            
            String html = "<h3>게시글목록</h3>";
            html += "<table border='2'>";
            html += "<thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th></tr></thead>";
            html += "<tbody>";
            for (BoardVO b : list) {
                html += "<tr>";
                html += "<td>" + b.getBoardNo() + "</a></td>";
                html += "<td><a href='getBoard?board_no=" + b.getBoardNo() + "'>" + b.getTitle() + "</td>";
                html += "<td>" + b.getWriter() + "</td>";
                html += "<td>" + b.getWriteDate() + "</td>";
                html += "</tr>";
            }
            html += "</tbody>";
            html += "</table>";
            
            out.print(html);
          } catch (Exception e) {
              e.printStackTrace();
          } // end of try
        
    } // end of service
    
    // 3. destroy()
    @Override
    public void destroy() {
        System.out.println("destroy() 호출. 서버가 종료될 때 실행됨.");
    }
}
