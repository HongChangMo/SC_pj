package com.sc.sc_pj.service.qa.repository;

import com.sc.sc_pj.service.qa.domain.QnaDomain;
import com.sc.sc_pj.service.qa.dto.QnaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QnaRepository extends JpaRepository<QnaDomain, Long>, JpaSpecificationExecutor<QnaDomain> {
    public QnaDomain findByQaNo(long qaNo);

    @Modifying
    @Query("update QnaDomain q set q.qaViews = IFNULL(q.qaViews, 0) + 1 where q.qaNo = :qaNo")
    int UpdateViews(@Param("qaNo") Long qaNo);

    @Query(value="select q from QnaDomain q join q.user where q.qaTitle like %:searchKeyWord% or q.qaContents like %:searchKeyWord% or q.user.userName like %:searchKeyWord%")
    Page<QnaDomain> findAll(@Param("searchKeyWord") String searchKeyWord, Pageable pageable);

    @Query(value="select q from QnaDomain q join q.user")
    Page<QnaDomain> findAll(Pageable pageable);
}
