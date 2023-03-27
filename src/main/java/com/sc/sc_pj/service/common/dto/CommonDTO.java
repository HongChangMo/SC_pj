package com.sc.sc_pj.service.common.dto;

import com.sc.sc_pj.service.common.domain.CommonDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class CommonDTO {
    private Long cmmId;
    private String cmmType;
    private String cmmCd;
    private String cmmNm;

}
