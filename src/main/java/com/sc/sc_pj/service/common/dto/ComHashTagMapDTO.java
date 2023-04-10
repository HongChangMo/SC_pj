package com.sc.sc_pj.service.common.dto;

import com.sc.sc_pj.service.common.domain.ComHashTagDomain;
import com.sc.sc_pj.service.common.domain.ComHashTagMapDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ComHashTagMapDTO {
    private Long htmNo;
    private Long htNo;
    private int typeCd;

    public ComHashTagMapDomain toEntity() {

        ComHashTagMapId comHashTagMapId = new ComHashTagMapId();

        comHashTagMapId.setHtmNo(htmNo);
        comHashTagMapId.setHtNo(htNo);
        comHashTagMapId.setTypeCd(typeCd);

        ComHashTagMapDomain comHashTagMapDomain = new ComHashTagMapDomain();
        comHashTagMapDomain.setComHashTagMapId(comHashTagMapId);

        return comHashTagMapDomain;
    }
}
