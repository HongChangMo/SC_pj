package com.sc.sc_pj.service.qa.dto;

import com.sc.sc_pj.service.qa.domain.QnaDomain;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
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
    private Integer qaViews;

    // 해시태그 배열
    private String[] hashtags;

    public QnaDomain toEntity() {
        return new QnaDomain(qaTopic, qaTitle, qaContents, qaWriter);
    }

    public QnaDTO(Long qaNo, String qaTopic, String qaTitle, String qaContents, String qaWriter, String qaWriteDt, String qaUpdateDt, int qaViews) {
        this.qaNo = qaNo;
        this.qaTopic = qaTopic;
        this.qaTitle = qaTitle;
        this.qaContents = qaContents;
        this.qaWriter = qaWriter;
        this.qaWriteDt = qaWriteDt;
        this.qaUpdateDt = qaUpdateDt;
        this.qaViews = qaViews;
    }
}
