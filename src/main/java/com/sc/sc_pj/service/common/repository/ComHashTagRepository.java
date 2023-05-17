package com.sc.sc_pj.service.common.repository;

import com.sc.sc_pj.service.common.domain.ComHashTagDomain;
import com.sc.sc_pj.service.common.domain.ComHashTagMapDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComHashTagRepository extends JpaRepository<ComHashTagDomain, Long> {
    // HashTag Name 검색
    @Query(value = "select ch from ComHashTagDomain ch where lower(ch.htNm) like lower('%'||:htNm||'%')")
    public List<ComHashTagDomain> findByHtNmContainingIgnoreCase(@Param("htNm") String htNm);

    public ComHashTagDomain findByHtNo(long htNo);

}
