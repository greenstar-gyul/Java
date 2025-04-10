package com.yedam.test;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImplements;
import com.yedam.vo.MemberVO;

public class AppTest {
    public static void main(String[] args) {
        MemberService svc = new MemberServiceImplements();
        MemberVO member = svc.login("user01", "1111");

        System.out.println(member);
    }
}
