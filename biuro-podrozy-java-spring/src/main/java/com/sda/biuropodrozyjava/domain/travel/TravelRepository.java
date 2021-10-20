package com.sda.biuropodrozyjava.domain.travel;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TravelRepository extends PagingAndSortingRepository<Travel, Long>, JpaSpecificationExecutor<Travel> {

    List<Travel> getTravelByPromotedTrue();

}
