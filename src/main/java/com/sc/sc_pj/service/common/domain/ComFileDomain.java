package com.sc.sc_pj.service.common.domain;

import com.sc.sc_pj.service.common.dto.ComFileID;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name="tb_file")
public class ComFileDomain implements Serializable {
    @EmbeddedId
    private ComFileID comFileID;

    @Column(name="file_save_path")
    private String fileSavePath;
    @Column(name="file_name")
    private String fileName;
    @Column(name="file_ext")
    private String fileExt;
    @Column(name="file_size")
    private Long fileSize;
    @Column(name="file_upload_dt")
    private String fileUploadDt;
    @Column(name="file_update_dt")
    private String fileUpdateDt;
    @Column(name="type_cd")
    private int typeCd;

    @Builder
    public ComFileDomain(String fileSavePath, String fileName, String fileExt, long fileSize, String fileUploadDt, String fileUpdateDt, int typeCd) {
        this.fileSavePath = fileSavePath;
        this.fileName = fileName;
        this.fileExt = fileExt;
        this.fileSize = fileSize;
        this.fileUploadDt = fileUploadDt;
        this.fileUpdateDt = fileUpdateDt;
        this.typeCd = typeCd;

    }

}
