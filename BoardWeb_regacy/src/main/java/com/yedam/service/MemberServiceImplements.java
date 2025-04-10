package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImplements implements MemberService {
    SqlSession sqlSession = DataSource.getInstance().openSession(true);
    MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

    @Override
    public MemberVO login(String id, String pw) {
        return mapper.selectMember(id, pw);
    }

    @Override
    public boolean addMember(MemberVO member) {
        return mapper.insertMember(member) > 0;
    }
    
    @Override
    public MemberVO getMember(String id) {
        return mapper.selectMemberId(id);
    }

    @Override
    public boolean changePasswd(MemberVO member) {
        return mapper.updatePasswd(member) > 0;
    }
}
