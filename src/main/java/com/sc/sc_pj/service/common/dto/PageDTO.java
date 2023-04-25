package com.sc.sc_pj.service.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
    private int pageNumber; // 현재페이지
    private int totalPages; // 총 페이지 수
    private int pageBlock = 5; // 블록 수
    private int startBlockPage;
    private int endBlockPage;

}
