package com.yedam.variable;

public class Member {
    // 필드: 값을 담기 위한 공간
    
    private String name;
    private int score;
    
    // 생성자
    // 정의하지 않으면 기본생성자 생성됨.
    public Member() {
        
    }
    
    public Member(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    // Set 컬렉션의 중복된 값으로 지정하기 위해
    @Override
    public int hashCode() {
        return score;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member mObj = (Member) obj;
            return this.name.equals(mObj.name) &&
                   this.score == mObj.score;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "이름: " + name + ", 점수: " + score;
    }
    
    // 메소드: 클래스 안에 소속된 함수
    public void showInfo() {
        System.out.println("이름: " + name + ", 점수: " + score);
    }
    
    public void setMember(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setScore(int score) {
        if (score < 0 || score > 100) {
            System.out.println("점수는 0이상 100이하인 정수입니다.");
            return;
        }
        this.score = score;
    }
    
}
