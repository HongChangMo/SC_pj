package com.sc.sc_pj.service.common.domain;

import com.sc.sc_pj.service.common.dto.ComHashTagMapId;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name="tb_hashtagmap")
public class ComHashTagMapDomain {

    @EmbeddedId
    private ComHashTagMapId comHashTagMapId;

    @Column(name="ht_no")
    private Long htNo;


    @Builder
    public ComHashTagMapDomain(long htNo) {
        this.htNo = htNo;
    }
}
