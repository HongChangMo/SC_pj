package com.sc.sc_pj.service.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ComFileDTO {
    private Long fileNo;
    private Long boardNo;
    private String fileSavePath;
    private String fileName;
    private String fileExt;
    private Long fileSize;
    private String fileUploadDt;
    private String fileUpdateDt;
    private int typeCd;

}
