package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.ChangePWControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.DeleteFormControl;
import com.yedam.control.JSControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.SignUpControl;

// *.do 요청에 대해서만 실행
public class FrontController extends HttpServlet {
    // 요청URL <=> 실행컨트롤 매핑
    Map<String, Control> map;
    
    // 생성자
    public FrontController() {
        map = new HashMap<>();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        map.put("/main.do", new MainControl()); // 상세화면        
        
        // 게시글 관련
        map.put("/board.do", new BoardControl()); // 상세화면
        map.put("/boardList.do", new BoardListControl()); // 목록
        map.put("/addBoard.do", new AddBoardControl()); // 글 등록
        map.put("/modifyForm.do", new ModifyFormControl()); // 수정화면
        map.put("/modifyBoard.do", new ModifyBoardControl()); // 수정처리
        map.put("/deleteForm.do", new DeleteFormControl()); // 삭제화면
        map.put("/deleteBoard.do", new DeleteBoardControl()); // 삭제처리
        
        // 로그인 관련
        map.put("/loginForm.do", new LoginFormControl()); // 로그인 화면        
        map.put("/login.do", new LoginControl()); // 로그인 화면        
        map.put("/logout.do", new LogoutControl()); // 로그인 화면        
        map.put("/signup.do", new SignUpControl()); // 회원가입
        map.put("/changepw.do", new ChangePWControl()); // 비밀번호 변경
        
        
        map.put("/javascript.do", new JSControl());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
         * URL vs URI
         * URL : 전체 주소의 값(프로토콜, 주소, 포트번호, 정보 등 모두 합한 것)
         * URI : 전체 주소에서 프로토콜, 주소, 포트번호를 뺀 나머지 부분
         * ex) URL : http://localhost:8080/BoardWeb/board.do
         *     URI : /BoardWeb/board.do
         */
        
        System.out.println("service 메소드 실행");
        String uri = req.getRequestURI();
        System.out.println("요청 URI: " + uri);
        
        String projectName = req.getContextPath(); 
        String page = uri.substring(projectName.length());
        System.out.println(page);
        
        Control sub = map.get(page);
        sub.exec(req, resp);
    }
}
