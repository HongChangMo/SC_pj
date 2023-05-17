package com.sc.sc_pj.service.register.repository;

import com.sc.sc_pj.service.register.domain.RegisterDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterDomain, Long> {
    @Query(value = "select count(*) from RegisterDomain r where r.userId=:userId")
    public Long CountByUserId(@Param("userId") String userId);

    public RegisterDomain findByUserNo(Long userNo);

    @Transactional
    @Modifying
    @Query(value = "update RegisterDomain r set r.userPwd = :userPwd, r.userNickName = :userNickName, r.userPhone = :userPhone where r.userNo=:userNo")
    int registerUpdate(@Param("userNo") long userNo,@Param("userPwd") String userPwd,@Param("userNickName") String userNickName, @Param("userPhone") String userPhone);
}
