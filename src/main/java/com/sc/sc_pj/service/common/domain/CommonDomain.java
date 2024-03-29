package com.sc.sc_pj.service.common.domain;

import com.sc.sc_pj.service.common.dto.CommonDTO;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@ToString
@Entity
@Getter
@Table(name = "tb_common")
public class CommonDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cmm_id")
    private Long cmmId;

    @Column(name="cmm_type")
    private String cmmType;

    @Column(name="cmm_cd")
    private String cmmCd;

    @Column(name="cmm_nm")
    private String cmmNm;

    @Builder
    public CommonDomain(String cmmType, String cmmCd, String cmmNm) {
        this.cmmType = cmmType;
        this.cmmCd = cmmCd;
        this.cmmNm = cmmNm;
    }

    public CommonDTO toDTO() {
        return new CommonDTO(cmmId, cmmType, cmmCd, cmmNm);
    }
}
