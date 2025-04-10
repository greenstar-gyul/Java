package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImplements;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("uname");
        String pw = req.getParameter("psw");
        
        MemberService svc = new MemberServiceImplements();
        MemberVO mvo = svc.login(id, pw);
        
        if (mvo == null) {
            req.setAttribute("msg", "아이디와 비밀번호를 확인하세요.");
            req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("logId", id);
            session.setAttribute("userName", mvo.getUserName());
            session.setAttribute("responsibility", mvo.getResponsibility());
            session.setAttribute("uImg", mvo.getImage());
//            resp.sendRedirect("boardList.do");
            
            if (mvo.getResponsibility().equals("User")) {                
                req.getRequestDispatcher("common/main.tiles").forward(req, resp);
            } else if (mvo.getResponsibility().equals("Admin")) {
                req.getRequestDispatcher("manager/main.tiles").forward(req, resp);                
            }
            
            
        }
    }

}
