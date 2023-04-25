package com.sc.sc_pj.service.common.repository;

import com.sc.sc_pj.service.common.domain.ComHashTagMapDomain;
import com.sc.sc_pj.service.common.dto.ComHashTagMapDTO;
import com.sc.sc_pj.service.common.dto.ComHashTagMapId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComHashTagMapRepository extends JpaRepository<ComHashTagMapDomain, ComHashTagMapId> {
    @Query(value = "select htm.* from tb_hashtagmap htm where htm.htm_no = :htmNo and htm.type_cd = :typeCd ", nativeQuery = true)
    public List<ComHashTagMapDomain> findTagMapsList(@Param("htmNo") long htmNo, @Param("typeCd") int typeCd);

    //@Query(value = "select htm.comHashTagMapId.htmNo, htm.comHashTagMapId.typeCd, htm.comHashTagMapId.htNo, htm.comHashTagDomain.htNo, htm.comHashTagDomain.htNm from ComHashTagMapDomain htm join htm.comHashTagDomain")

    public List<ComHashTagMapDomain> findAll();
}
