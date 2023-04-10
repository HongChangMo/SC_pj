package com.sc.sc_pj.service.qa.repository;

import com.sc.sc_pj.service.qa.domain.QnaDomain;
import com.sc.sc_pj.service.qa.dto.QnaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QnaRepository extends JpaRepository<QnaDomain, Long> {
    public QnaDomain findByQaNo(long qaNo);

    @Modifying
    @Query("update QnaDomain q set q.qaViews = IFNULL(q.qaViews, 0) + 1 where q.qaNo = :qaNo")
    int UpdateViews(@Param("qaNo") Long qaNo);
}
