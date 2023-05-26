package com.sc.sc_pj.service.knowledge.dto;

import com.sc.sc_pj.service.knowledge.domain.KnowledgeDomain;
import com.sc.sc_pj.service.login.dto.UserDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class KnowledgeDTO {
    private Long knNo;
    private String knTopic;
    private String knTitle;
    private String knContents;
    private String knWriter;
    private String knWriteDt;
    private String knUpdateDt;
    private Integer knViews;

    // 해시태그 배열
    private String[] hashtags;

    private UserDTO userDTO;

    public KnowledgeDomain toEntity() {
        return new KnowledgeDomain(knTopic, knTitle, knContents, knWriter);
    }

    public KnowledgeDTO(Long knNo, String knTopic, String knTitle, String knContents, String knWriter, String knWriteDt, String knUpdateDt, int knViews) {
        this.knNo = knNo;
        this.knTopic = knTopic;
        this.knTitle = knTitle;
        this.knContents = knContents;
        this.knWriter = knWriter;
        this.knWriteDt = knWriteDt;
        this.knUpdateDt = knUpdateDt;
        this.knViews = knViews;
    }

    public KnowledgeDTO(KnowledgeDomain domain) {
        this.knNo = domain.getKnNo();
        this.knTopic = domain.getKnTopic();
        this.knTitle = domain.getKnTitle();
        this.knContents = domain.getKnContents();
        this.knWriter = domain.getKnWriter();
        this.knWriteDt = domain.getKnWriteDt().toString();
        this.knUpdateDt = domain.getKnUpdateDt().toString();
        this.knViews = domain.getKnViews();
        this.userDTO = domain.getUser().toDTO();
    }
}
