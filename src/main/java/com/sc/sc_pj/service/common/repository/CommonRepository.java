package com.sc.sc_pj.service.common.repository;

import com.sc.sc_pj.service.common.domain.CommonDomain;
import com.sc.sc_pj.service.common.dto.CommonDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonRepository extends JpaRepository<CommonDomain, Long> {

        // Com_type 검색
        public List<CommonDTO> findByCmmType(String cmmType);

}
