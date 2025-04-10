package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession = DataSource.getInstance().openSession();
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        int bno = Integer.parseInt(req.getParameter("bno"));
        int page = Integer.parseInt(req.getParameter("page"));
        BoardVO board = mapper.selectOne(bno);
        req.setAttribute("brd", board);
        req.setAttribute("page", page);
        req.getRequestDispatcher("board/boardOne.tiles").forward(req, resp);
    }
    
}
