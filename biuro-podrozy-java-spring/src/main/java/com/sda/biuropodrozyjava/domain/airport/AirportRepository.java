package com.sda.biuropodrozyjava.domain.airport;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByNameLike(String name);

}
