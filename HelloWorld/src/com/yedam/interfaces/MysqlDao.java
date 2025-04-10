package com.yedam.interfaces;

// 메소드 명을 insert, modify, remove로 명명
// OracleDao에서는 add, modify, delete로 명명
// 이름이 제각각이 되어버림.

public class MysqlDao implements Dao {
    @Override
    public void insert() {
        System.out.println("mysql INSERT");
    }
    
    @Override
    public void update() {
        System.out.println("mysql UPDATE");
    }
    
    @Override
    public void delete() {
        System.out.println("mysql DELETE");
    }
}
