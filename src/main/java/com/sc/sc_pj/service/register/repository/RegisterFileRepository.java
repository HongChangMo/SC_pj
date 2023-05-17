package com.sc.sc_pj.service.register.repository;

import com.sc.sc_pj.service.register.domain.RegisterFileDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterFileRepository extends JpaRepository<RegisterFileDomain, Long> {
    public RegisterFileDomain findByUserNo(long userNo);
}
