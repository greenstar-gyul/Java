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

public class ModifyBoardControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bno = Integer.parseInt(req.getParameter("bno"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int page = Integer.parseInt(req.getParameter("page"));
        
        SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession(true) -> 자동커밋
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        
        BoardVO board = new BoardVO();
        board.setBoardNo(bno);
        board.setTitle(title);
        board.setContent(content);
        
        req.setAttribute("page", page);
        int r = mapper.updateBoard(board);
        if (r > 0) {
            resp.sendRedirect("boardList.do?page="+page);
        }
        else {
            System.err.println("수정 과정에서 오류 발생");
        }
    }

}
