package com.sc.sc_pj.service.common.repository;

import com.sc.sc_pj.service.common.domain.ComFileDomain;
import com.sc.sc_pj.service.common.dto.ComFileID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComFileRepository extends JpaRepository<ComFileDomain, ComFileID> {
}
