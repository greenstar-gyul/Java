package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bno = Integer.parseInt(req.getParameter("bno"));
        int page = Integer.parseInt(req.getParameter("page"));
        
        SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession(true) -> 자동커밋
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        BoardVO board = mapper.selectOne(bno);
        req.setAttribute("brd", board);
        req.setAttribute("page", page);
        
        // 권한 체크
        HttpSession session = req.getSession();
        String logId = (String) session.getAttribute("logId");
        if (logId != null && logId.equals(board.getWriter())) {
            req.getRequestDispatcher("board/modifyBoard.tiles").forward(req, resp);            
        } else {
            req.setAttribute("msg", "권한이 없습니다.");
            req.getRequestDispatcher("board/boardOne.tiles").forward(req, resp);
        }
    }

}
