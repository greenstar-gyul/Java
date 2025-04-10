package com.yedam.inheritance;

/*
 * Friend2: Friend 상속
 */
public class UnivFriend extends Friend {
    private String univName;
    private String major;
    
    public UnivFriend() { }
    public UnivFriend(String name, String tel, String univName, String major) {
        super(name, tel);
        this.univName = univName;
        this.major = major;
    }
    
    // 부모의 메소드를 자식이 재정의 -> overriding
    @Override
    public String getName() {
        return super.getName();
    }
    
//    @Override
//    private void setName() {
//        // 부모 클래스의 final 메소드는 overriding 불가
//    }
    
    @Override
    public String toString() {
        return super.toString() + ", 학교는 " + getUnivName() + ", 전공은 " + getMajor();
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
