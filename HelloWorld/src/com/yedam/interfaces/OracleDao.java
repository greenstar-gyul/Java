package com.yedam.interfaces;

// 메소드 명을 add, modify, delete로 명명

public class OracleDao implements Dao {
    @Override
    public void insert() {
        System.out.println("Oracle INSERT");
    }
    
    @Override
    public void update() {
        System.out.println("Oracle UPDATE");
    }
    
    @Override
    public void delete() {
        System.out.println("Oracle DELETE");
    }
}
