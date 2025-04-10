package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
@WebServlet("/addBoard")
public class AddBoard extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // addForm.jsp -> AddBoardServlet(title, writer, content)
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        String content = req.getParameter("content");

        BoardVO board = new BoardVO();
        board.setTitle(title);
        board.setWriter(writer);
        board.setContent(content);
        System.out.println(board);

        SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession(true) -> 자동커밋
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        int r = mapper.insertBoard(board);

        resp.getWriter().print(r + "건 처리");
    }
}
