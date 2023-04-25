package com.sc.sc_pj.service.common.domain;

import com.sc.sc_pj.service.common.dto.ComHashTagDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@ToString
@Getter
@Entity
@Table(name="tb_hashtag")
public class ComHashTagDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ht_no")
    private Long htNo;

    @Column(name="ht_nm")
    private String htNm;

    @OneToMany(mappedBy = "comHashTagDomain")
    private List<ComHashTagMapDomain> tagMapsList = new ArrayList<>();

    @Builder
    public ComHashTagDomain(String htNm) {
        this.htNm = htNm;
    }

    public ComHashTagDTO toDTO() {
        return new ComHashTagDTO(htNo, htNm);
    }
}
