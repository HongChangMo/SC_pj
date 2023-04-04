package com.sc.sc_pj.service.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComFileID implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="file_no")
    private Long fileNo;
    @Column(name="board_no")
    private Long boardNo;
}
