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

public class ChangePWControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("GET")) {
            req.getRequestDispatcher("member/changePWForm.tiles").forward(req, resp);

        } else if (req.getMethod().equals("POST")) {
            HttpSession session = req.getSession();
            String logId = (String) session.getAttribute("logId");

            MemberService svc = new MemberServiceImplements();
            MemberVO mvo = svc.getMember(logId);

            String cpw = req.getParameter("current_pw");

            if (!mvo.getPassword().equals(cpw)) {// 비밀번호 다름.
                req.setAttribute("msg", "현재 비밀번호가 달라요!!");
                req.getRequestDispatcher("member/changePWForm.tiles").forward(req, resp);
                return;
            }

            String npw = req.getParameter("new_pw");
            String rpw = req.getParameter("confirm_pw");
            
            if (!npw.equals(rpw)) {// 새로 선택한 비밀번호 다름.
                req.setAttribute("msg", "새로 입력한 비밀번호가 달라요!!");
                req.getRequestDispatcher("member/changePWForm.tiles").forward(req, resp);
                return;
            }
            
            mvo.setPassword(npw);

            svc.changePasswd(mvo);
            resp.sendRedirect("loginForm.do");
        }
    }

}
