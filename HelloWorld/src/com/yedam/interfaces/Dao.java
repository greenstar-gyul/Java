package com.yedam.interfaces;

/*
 * DAO
 * Data Access Object
 * 
 * interface
 * 인터페이스의 메소드는 추상메소드임
 * 
 * interface 사용 예)
 * database 접근 방법으로
 * 1차 project에서 mysql에 대한 클래스 생성(MysqlDao)
 * 후에 2차 project에서 oracle에 대한 클래스 다시 생성(OracleDao)
 * 
 * 
 */

public interface Dao {
    void insert();
    void update();
    void delete();
    
}
