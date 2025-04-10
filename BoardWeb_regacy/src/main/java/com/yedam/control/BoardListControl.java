package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 글목록 정보 -> jsp
        SqlSession sqlSession = DataSource.getInstance().openSession();
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        String strPage = req.getParameter("page");
        String sc = req.getParameter("searchCondition");
        String kw = req.getParameter("keyword");
        
        int page = 0;
        if (strPage == null)
            page = 1;
        else
            page = Integer.parseInt(req.getParameter("page"));
        
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setKeyword(kw);
        searchDTO.setPage(page);
        searchDTO.setSearchCondition(sc);
        
        int totalCnt = mapper.selectTotal(searchDTO);
        PageDTO pageDTO = new PageDTO(totalCnt, page);
        List<BoardVO> list = mapper.selectBoard(searchDTO);
        req.setAttribute("blist", list);
        req.setAttribute("page", pageDTO);
        req.setAttribute("searchCondition", sc);
        req.setAttribute("keyword", kw);
        
        // 호출되는 페이지 : boardList.do -> 출력 : test.jsp, forward : 페이지재지정
        req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
    }
   
}