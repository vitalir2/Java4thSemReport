package com.example.finalprj.repository;

import com.example.finalprj.model.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class ProductSpecifications {

    public static Specification<Product> findByNameAndPrice(String name, int price) {
        return (root, query, criteriaBuilder) -> {
            Predicate namePredicate = null;
            Predicate pricePredicate = null;
            if (!name.isBlank()) {
                namePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), name);
            }
            if (price != 0) {
                pricePredicate = criteriaBuilder.equal(root.get("price"), price);
            }
            return criteriaBuilder.and(namePredicate, pricePredicate);
        };
    }
}
