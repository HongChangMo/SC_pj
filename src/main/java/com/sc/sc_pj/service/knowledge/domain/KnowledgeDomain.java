package com.sc.sc_pj.service.knowledge.domain;

import com.sc.sc_pj.service.knowledge.dto.KnowledgeDTO;
import com.sc.sc_pj.service.login.domain.UserDomain;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@ToString
@Getter
@Entity
@Table(name = "tb_knowledge")
public class KnowledgeDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kn_no")
    private Long knNo;

    @Column(name="kn_topic")
    private String knTopic;
    @Column(name="kn_title")
    private String knTitle;
    @Column(name="kn_contents")
    private String knContents;
    @Column(name="kn_writer")
    private String knWriter;
    @Column(name="kn_write_dt")
    private LocalDateTime knWriteDt;
    @Column(name="kn_update_dt")
    private LocalDateTime knUpdateDt;
    @Column(name="kn_views")
    private Integer knViews;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="kn_writer", referencedColumnName="user_id", insertable = false, updatable = false)
    private UserDomain user;

    @Builder
    public KnowledgeDomain(String knTopic, String knTitle, String knContents, String knWriter) {
        this.knTopic = knTopic;
        this.knTitle = knTitle;
        this.knContents = knContents;
        this.knWriter = knWriter;
    }

    @PrePersist
    public void prePersist() {
        this.knWriteDt = LocalDateTime.now();
        this.knUpdateDt = knWriteDt;
    }

    @PreUpdate
    public void preUpdate() {
        this.knUpdateDt = LocalDateTime.now();
    }

    public KnowledgeDTO toDTO() {
        return new KnowledgeDTO(knNo, knTopic, knTitle, knContents, knWriter, knWriteDt.toString(), knUpdateDt.toString(), knViews);
    }
}
