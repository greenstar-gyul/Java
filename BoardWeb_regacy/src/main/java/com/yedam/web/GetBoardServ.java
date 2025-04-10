package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

// 서블릿 -> jsp

@WebServlet("/getBoard")
public class GetBoardServ extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardNo = Integer.parseInt(req.getParameter("board_no"));

        SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession(true) -> 자동커밋
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        BoardVO board = mapper.selectOne(boardNo);

        System.out.println(board);

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        String html = "<h3>상세조회(⩌⩊⩌)</h3>" //
                + "<ul>" //
                + "<li>글번호 " + board.getBoardNo() + "</li>" //
                + "<li>글제목 " + board.getTitle() + "</li>" //
                + "<li>글쓴이 " + board.getWriter() + "</li>" //
                + "<li>글내용 " + board.getContent() + "</li>" //
                + "<li>쓴날짜 " + board.getWriteDate() + "</li>" //
                + "</ul>";
        html += "<a href='mainservlet'>목록으로<a></p>";
        
        out.print(html);
    }
}
