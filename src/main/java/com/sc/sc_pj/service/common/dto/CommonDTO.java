package com.sc.sc_pj.service.common.dto;

import com.sc.sc_pj.service.common.domain.CommonDomain;
import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class CommonDTO {
    private Long cmmId;
    private String cmmType;
    private String cmmCd;
    private String cmmNm;

    public CommonDomain toEntity() {
        return new CommonDomain(cmmType, cmmCd, cmmNm);
    }

    public CommonDTO(Long cmmId, String cmmType, String cmmCd, String cmmNm) {
        this.cmmId = cmmId;
        this.cmmType = cmmType;
        this.cmmCd = cmmCd;
        this.cmmNm = cmmNm;
    }

}
