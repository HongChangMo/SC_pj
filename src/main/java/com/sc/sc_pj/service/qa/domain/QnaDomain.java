package com.sc.sc_pj.service.qa.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@ToString
@Entity
@Table(name="tb_qna")
public class QnaDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="qa_no")
    private Long qaNo;

    @Column(name="qa_topic")
    private String qaTopic;
    @Column(name="qa_title")
    private String qaTitle;
    @Column(name="qa_contents")
    private String qaContents;
    @Column(name="qa_writer")
    private String qaWriter;
    @Column(name="qa_write_dt")
    private LocalDateTime qaWriteDt;
    @Column(name="qa_update_dt")
    private LocalDateTime qaUpdateDt;

    @Builder
    public QnaDomain(String qaTopic, String qaTitle, String qaContents, String qaWriter) {
        this.qaTopic = qaTopic;
        this.qaTitle = qaTitle;
        this.qaContents = qaContents;
        this.qaWriter = qaWriter;
    }

    @PrePersist
    public void prePersist() {
        this.qaWriteDt = LocalDateTime.now();
        this.qaUpdateDt = qaWriteDt;
    }

    @PreUpdate
    public void preUpdate() {
        this.qaUpdateDt = LocalDateTime.now();
    }

}
