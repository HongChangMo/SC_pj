package com.sc.sc_pj.service.qa.repository;

import com.sc.sc_pj.service.qa.domain.QnaDomain;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.criteria.Predicate;

public class QnaSpecification {
    public static Specification<QnaDomain> searchQnaDTO(Map<String, Object> searchKey) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates  = new ArrayList<>();
            for( String key : searchKey.keySet() ) {
                predicates.add( criteriaBuilder.equal(root.get(key), searchKey.get(key)));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

    }
}
