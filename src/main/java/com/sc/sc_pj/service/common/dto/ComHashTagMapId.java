package com.sc.sc_pj.service.common.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
public class ComHashTagMapId implements Serializable {
    @Column(name="htm_no")
    private Long htmNo;
    @Column(name="type_cd")
    private int typeCd;

    @Column(name="ht_no")
    private Long htNo;
}
