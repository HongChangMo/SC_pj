package com.sc.sc_pj.service.common.domain;

import com.sc.sc_pj.service.common.dto.ComCommentDTO;
import com.sc.sc_pj.service.login.domain.UserDomain;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@ToString
@Entity
@Getter
@Table(name="tb_comment")
public class ComCommentDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_no")
    private Long cNo;

    @Column(name="c_board_no")
    private int cBoardNo;

    @Column(name="c_type")
    private int cType;

    @Column(name="c_writer")
    private String cWriter;

    @Column(name="c_content")
    private String cContent;

    @Column(name="c_write_dt")
    private LocalDateTime cWriteDt;

    @Column(name="c_update_dt")
    private LocalDateTime cUpdateDt;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name="c_writer", referencedColumnName = "user_id", insertable = false, updatable = false)
    private UserDomain userDomain;

    @Builder
    public ComCommentDomain(int cBoardNo, int cType, String cWriter, String cContent) {
        this.cBoardNo = cBoardNo;
        this.cType = cType;
        this.cWriter = cWriter;
        this.cContent = cContent;
    }

    @PrePersist
    public void prePersist() {
        this.cWriteDt = LocalDateTime.now();
        this.cUpdateDt = cWriteDt;
    }

    @PreUpdate
    public void preUpdate() {
        this.cUpdateDt = LocalDateTime.now();
    }

    public ComCommentDTO toDTO() {
        return new ComCommentDTO(cNo, cBoardNo, cType, cWriter, cContent, cWriteDt.toString(), cUpdateDt.toString(), userDomain.toDTO());
    }
}
