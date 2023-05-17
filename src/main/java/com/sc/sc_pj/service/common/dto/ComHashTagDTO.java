package com.sc.sc_pj.service.common.dto;

import com.sc.sc_pj.service.common.domain.ComHashTagDomain;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ComHashTagDTO {
    private Long htNo;
    private String htNm;

    public ComHashTagDomain toEntity() {
        return new ComHashTagDomain(htNm);
    }

    public ComHashTagDTO(ComHashTagDomain domain) {
        this.htNo = domain.getHtNo();
        this.htNm = domain.getHtNm();
    }

}
