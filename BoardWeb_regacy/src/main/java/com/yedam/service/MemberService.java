package com.yedam.service;

import com.yedam.vo.MemberVO;

public interface MemberService {
    MemberVO login(String id, String pw);
    boolean addMember(MemberVO member);
    MemberVO getMember(String id);
    boolean changePasswd(MemberVO member);
}
