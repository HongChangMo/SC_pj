package com.sc.sc_pj.service.register.dto;

import com.sc.sc_pj.service.register.domain.RegisterFileDomain;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class RegisterFileDTO {
    private Long userNo;
    private String fileSavePath;
    private String fileOriginNm;
    private String fileSaveNm;
    private long fileSize;
    private String fileExt;
    private String fileThumbPath;
    private String fileThumbNm;
    private String fileThumbExt;
    private String uploadDt;
    private String updateDt;

    public RegisterFileDomain toEntity() {
        return new RegisterFileDomain(userNo,fileSavePath, fileOriginNm, fileSaveNm, fileSize, fileExt, fileThumbPath, fileThumbNm, fileThumbExt);
    }
}
