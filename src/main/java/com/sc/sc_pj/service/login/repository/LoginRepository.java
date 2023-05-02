package com.sc.sc_pj.service.login.repository;

import com.sc.sc_pj.service.login.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public interface LoginRepository extends JpaRepository<UserDomain, Long> {
    public Optional<UserDomain> findByUserId(String userId);
}
