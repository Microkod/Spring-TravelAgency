package com.sda.biuropodrozyjava.domain.travel;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TravelSpecification implements Specification<Travel> {

    private final TravelSearchCriteria travelSearchCriteria;

    public TravelSpecification(TravelSearchCriteria travelSearchCriteria) {
        this.travelSearchCriteria = travelSearchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Travel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (travelSearchCriteria.getCountryId() != null) {
            predicates.add(criteriaBuilder.equal(
                    root.join("hotel")
                            .join("city")
                            .join("country")
                            .get("id"), travelSearchCriteria.getCountryId()));
        } else if (travelSearchCriteria.getContinentId() != null) {
            predicates.add(criteriaBuilder.equal(
                    root.join("hotel")
                            .join("city")
                            .join("country")
                            .join("continent")
                            .get("id"), travelSearchCriteria.getContinentId()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
