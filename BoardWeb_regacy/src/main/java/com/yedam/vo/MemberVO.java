package com.yedam.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberVO {
    private String userID;
    private String password;
    private String userName;
    private String responsibility;
    private String image;
}
