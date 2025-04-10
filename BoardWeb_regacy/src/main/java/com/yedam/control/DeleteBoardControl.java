package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;

public class DeleteBoardControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bno = Integer.parseInt(req.getParameter("bno"));
        
        SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession(true) -> 자동커밋
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        int r = mapper.deleteBoard(bno);
        if (r > 0) {
            resp.sendRedirect("boardList.do");
        }
        else {
            System.err.println("삭제 과정에서 오류 발생");
        }
    }

}
