package com.sda.biuropodrozyjava.domain.city;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByCountry_Id(Long id);

}
