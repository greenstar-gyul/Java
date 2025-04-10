package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImplements;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        
        // 1. 회원가입 화면 (GET)
        if (req.getMethod().equals("GET")) {
            req.getRequestDispatcher("board/signupForm.tiles").forward(req, resp);
        }
        // 2. 회원가입 처리 (POST)
        else if (req.getMethod().equals("POST")) {
            /*
             *  MultipartRequest (
             *      HttpServletRequest request,  => 요청정보
             *      String saveDirectory,        => 파일 저장 경로
             *      int maxPostSize,             => 파일 최대 크기(Byte)
             *      String encoding,             => 파일 인코딩 방식
             *      FileRenamePolicy policy      => rename 정책(이름 중복될 때 어쩔건지)
             *  )
             */

            String saveDirectory = req.getServletContext().getRealPath("images");
            int maxPostSize = 1024 * 1024 * 5;
            String encoding = "UTF-8";
            MultipartRequest mr = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
            
            String id = mr.getParameter("userId");
            String pw = mr.getParameter("userPw");
            String pwc = mr.getParameter("userPwc");
            String name = mr.getParameter("userName");
            String img = mr.getFilesystemName("userImg");
            
            if (pw.equals(pwc)) {
                MemberVO mvo = new MemberVO();
                mvo.setUserID(id);
                mvo.setPassword(pw);
                mvo.setUserName(name);
                mvo.setImage(img);
                
                MemberService svc = new MemberServiceImplements();
                if (svc.addMember(mvo)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("logId", id);
                    session.setAttribute("uImg", mvo.getImage());
                    resp.sendRedirect("main.do");
                }
                else {
                    System.err.println("처리오류");
                }
            }
            else {
                req.getRequestDispatcher("board/signupForm.tiles").forward(req, resp);
            }
        }
    }

}
