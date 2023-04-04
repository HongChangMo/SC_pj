package com.sc.sc_pj.service.common.dto;

import com.sc.sc_pj.service.common.domain.ComHashTagDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ComHashTagDTO {
    private Long htNo;
    private String htNm;

    public ComHashTagDomain toEntity() {
        return new ComHashTagDomain(htNm);
    }
}
