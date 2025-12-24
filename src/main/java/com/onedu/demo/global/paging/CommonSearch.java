package com.onedu.demo.global.paging;

import lombok.Data;

@Data
public class CommonSearch {
    
    private int page = 1;
    
    private int limit = 20;
    
    // 검색 옵션
    private String sopt;
    
    // 검색 키워드
    private String skey;
}
