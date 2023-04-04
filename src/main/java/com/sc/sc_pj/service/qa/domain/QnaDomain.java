package com.sc.sc_pj.service.qa.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
    private String qaWriteDt;
    @Column(name="qa_update_dt")
    private String qaUpdateDt;

    @Builder
    public QnaDomain(String qaTopic, String qaTitle, String qaContents, String qaWriter, String qaWriteDt, String qaUpdateDt) {
        this.qaTopic = qaTopic;
        this.qaTitle = qaTitle;
        this.qaContents = qaContents;
        this.qaWriter = qaWriter;
        this.qaWriteDt = qaWriteDt;
        this.qaUpdateDt = qaUpdateDt;
    }
}
