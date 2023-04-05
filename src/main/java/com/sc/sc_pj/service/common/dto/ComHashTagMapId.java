package com.sc.sc_pj.service.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComHashTagMapId implements Serializable {
    @Column(name="htm_no")
    private Long htmNo;
    @Column(name="type_cd")
    private int typeCd;
}
