package com.sc.sc_pj.service.common.domain;

import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.ComHashTagMapId;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="tb_hashtagmap")
public class ComHashTagMapDomain {

    @EmbeddedId
    private ComHashTagMapId comHashTagMapId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ht_no", referencedColumnName = "ht_no", insertable = false, updatable = false)
    private ComHashTagDomain comHashTagDomain;

    public ComHashTagMapDTO toDTO() {
        return new ComHashTagMapDTO(comHashTagMapId.getHtmNo(), comHashTagMapId.getHtNo(), comHashTagMapId.getTypeCd(), comHashTagDomain.toDTO());
    }


}
