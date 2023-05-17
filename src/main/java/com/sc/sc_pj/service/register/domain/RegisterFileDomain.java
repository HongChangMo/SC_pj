package com.sc.sc_pj.service.register.domain;

import com.sc.sc_pj.service.register.dto.RegisterFileDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="tb_user_file")
public class RegisterFileDomain {
    @Id
    @Column(name="user_no")
    private Long userNo;

    @Column(name="file_save_path")
    private String fileSavePath;

    @Column(name="file_origin_nm")
    private String fileOriginNm;

    @Column(name="file_save_nm")
    private String fileSaveNm;

    @Column(name="file_size")
    private long fileSize;

    @Column(name="file_ext")
    private String fileExt;
    @Column(name="file_thumb_path")
    private String fileThumbPath;
    @Column(name="file_thumb_nm")
    private String fileThumbNm;
    @Column(name="file_thumb_ext")
    private String fileThumbExt;

    @Column(name="upload_dt", updatable = false)
    private LocalDateTime uploadDt;

    @Column(name="update_dt")
    private LocalDateTime updateDt;

    @PrePersist
    public void prePersist() {
        this.uploadDt = LocalDateTime.now();
        this.updateDt = uploadDt;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateDt = LocalDateTime.now();
    }

    @Builder
    public RegisterFileDomain(Long userNo, String fileSavePath, String fileOriginNm, String fileSaveNm, long fileSize, String fileExt, String fileThumbPath, String fileThumbNm, String fileThumbExt) {
        this.userNo = userNo;
        this.fileSavePath = fileSavePath;
        this.fileOriginNm = fileOriginNm;
        this.fileSaveNm = fileSaveNm;
        this.fileSize = fileSize;
        this.fileExt = fileExt;
        this.fileThumbPath = fileThumbPath;
        this.fileThumbNm = fileThumbNm;
        this.fileThumbExt = fileThumbExt;
    }

    public RegisterFileDTO toDTO() {
        return new RegisterFileDTO(userNo, fileSavePath, fileOriginNm, fileSaveNm, fileSize, fileExt, uploadDt.toString(), updateDt.toString(), fileThumbPath, fileThumbNm, fileThumbExt);
    }

}
