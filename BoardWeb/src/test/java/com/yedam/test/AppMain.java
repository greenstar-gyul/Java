package com.yedam.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;

public class AppMain {
	public static void main(String[] args) {
//      MemberService svc = new MemberServiceImpl();
//      MemberVO member = svc.login("user01", "1111");
//
//      System.out.println(member.toString());
        SqlSession sqlSession = DataSource.getInstance().openSession(true);
        EventMapper mapper = sqlSession.getMapper(EventMapper.class);
        
        List<Map<String, Object>> list = mapper.selectWriter();
        
        Gson gson =new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
