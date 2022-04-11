package com.example.finalprj.repository;

import com.example.finalprj.model.Market;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class MarketSpecifications {

    public static Specification<Market> findMarketByNameAndAddress(String name, String address) {
        return (root, query, criteriaBuilder) -> {
            Predicate namePredicate = null;
            Predicate addressPredicate = null;
            if (!name.isBlank()) {
                namePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), name);
            }
            if (!address.isBlank()) {
                addressPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("address")), address);
            }
            return criteriaBuilder.and(namePredicate, addressPredicate);
        };
    }
}
