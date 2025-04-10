package com.yedam.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
    private int startPage;
    private int endPage;
    private int currentPage;
    private boolean prev, next;
    
    public PageDTO(int totalCnt, int page) {
        currentPage = page;
        endPage = (int) (Math.ceil(page / 10.0) * 10);
        startPage = endPage - 9;
        int realEnd = (int) (Math.ceil(totalCnt / 5.0));
        endPage = endPage > realEnd ? realEnd : endPage;
        
        prev = startPage > 1 ? true : false;
        next = endPage < realEnd? true : false;
    }
}
