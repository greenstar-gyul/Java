package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        
        if (req.getMethod().equals("GET")) {
            req.getRequestDispatcher("board/addForm.tiles").forward(req, resp);
        }
        else if (req.getMethod().equals("POST")) {
            // 등록
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
            try {
                int r = mapper.insertBoard(board);
                
                if (r > 0) {
                    System.out.println("등록성공");
                }
            } catch (Exception e) {
                System.err.println("오류 발생!!!");
                System.err.println(e);
            }
            
            resp.sendRedirect("boardList.do");
        }
    }
}
