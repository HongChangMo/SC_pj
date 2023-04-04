package com.sc.sc_pj.service.common.repository;

import com.sc.sc_pj.service.common.domain.ComHashTagDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComHashTagRepository extends JpaRepository<ComHashTagDomain, Long> {
    // HashTag Name 검색
    public List<ComHashTagDTO> findByHtNmLike(String htNm);

}
