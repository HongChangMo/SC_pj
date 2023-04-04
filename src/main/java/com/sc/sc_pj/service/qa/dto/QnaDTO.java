package com.sc.sc_pj.service.qa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class QnaDTO {
    private Long qaNo;
    private String qaTopic;
    private String qaTitle;
    private String qaContents;
    private String qaWriter;
    private String qaWriteDt;
    private String qaUpdateDt;

    // 해시태그 배열
    private String[] hashtags;
}
