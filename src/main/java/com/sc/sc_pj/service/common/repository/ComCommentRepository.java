package com.sc.sc_pj.service.common.repository;

import com.sc.sc_pj.service.common.domain.ComCommentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ComCommentRepository extends JpaRepository<ComCommentDomain, Long> {
    @Query( value = "select c from ComCommentDomain c where c.cBoardNo = :cBoardNo and c.cType = :cType" )
    public List<ComCommentDomain> findBoardNoAndType(@Param("cBoardNo") int cBoardNo,@Param("cType") int cType);

    @Transactional
    public Long deleteBycNo(long cNo);
}
