package com.yedam.interfaces;

public class ServiceApp {
    public static void main(String[] args) {
//        MysqlDao dao = new MysqlDao();
//        OracleDao dao = new OracleDao();
        Dao dao = new OracleDao();
        dao.insert();
        dao.update();
        dao.delete();
    }   
}
