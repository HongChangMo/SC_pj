package com.sc.sc_pj.service.knowledge.repository;

import com.sc.sc_pj.service.knowledge.domain.KnowledgeDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeRepository extends JpaRepository<KnowledgeDomain, Long> {

    public KnowledgeDomain findByKnNo(long knNo);

    @Modifying
    @Query("update KnowledgeDomain k set k.knViews = IFNULL(k.knViews, 0) + 1 where k.knNo = :knNo")
    int UpdateViews(@Param("knNo") Long knNo);

    @Query(value="select k from KnowledgeDomain k join k.user where k.knTitle like %:searchKeyWord% or k.knContents like %:searchKeyWord% or k.user.userName like %:searchKeyWord%")
    Page<KnowledgeDomain> findAll(@Param("searchKeyWord") String searchKeyWord, Pageable pageable);

    @Query(value="select k from KnowledgeDomain k join k.user where k.knTopic = :searchTopic and (k.knTitle like %:searchKeyWord% or k.knContents like %:searchKeyWord% or k.user.userName like %:searchKeyWord%)")
    Page<KnowledgeDomain> findAll(@Param("searchKeyWord") String searchKeyWord, @Param("searchTopic") String searchTopic, Pageable pageable);

    @Query(value="select k from KnowledgeDomain k join k.user")
    Page<KnowledgeDomain> findAll(Pageable pageable);
}
