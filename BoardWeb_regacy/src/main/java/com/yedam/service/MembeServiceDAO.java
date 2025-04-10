package com.yedam.service;

import com.yedam.vo.MemberVO;

/*
 * MemberService(인터페이스) - 규칙
 * MemberServiceDAO - jdbc 구현부
 * MemberServiceImplements - mybatis 구현부
 */

public class MembeServiceDAO implements MemberService {

    @Override
    public MemberVO login(String id, String pw) {
        return null;
    }

    @Override
    public boolean addMember(MemberVO member) {
        return false;
    }

    @Override
    public MemberVO getMember(String id) {
        return null;
    }

    @Override
    public boolean changePasswd(MemberVO member) {
        return false;
    }

}
