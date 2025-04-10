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

public class DeleteFormControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bno = Integer.parseInt(req.getParameter("bno"));
        
        SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession(true) -> 자동커밋
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        BoardVO board = mapper.selectOne(bno);
        int page = Integer.parseInt(req.getParameter("page"));
        req.setAttribute("brd", board);
        req.setAttribute("page", page);
        req.getRequestDispatcher("board/deleteBoard.tiles").forward(req, resp);
    }

}
