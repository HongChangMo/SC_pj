package com.sc.sc_pj.service.register.repository;

import com.sc.sc_pj.service.register.domain.RegisterDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterDomain, Long> {
    @Query(value = "select count(*) from RegisterDomain r where r.userId=:userId")
    public Long CountByUserId(@Param("userId") String userId);
}
