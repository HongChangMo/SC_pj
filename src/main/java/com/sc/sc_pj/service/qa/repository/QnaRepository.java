package com.sc.sc_pj.service.qa.repository;

import com.sc.sc_pj.service.qa.domain.QnaDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QnaRepository extends JpaRepository<QnaDomain, Long> {

}
