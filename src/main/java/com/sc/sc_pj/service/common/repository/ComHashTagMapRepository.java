package com.sc.sc_pj.service.common.repository;

import com.sc.sc_pj.service.common.domain.ComHashTagMapDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagMapId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComHashTagMapRepository extends JpaRepository<ComHashTagMapDomain, ComHashTagMapId> {

}
