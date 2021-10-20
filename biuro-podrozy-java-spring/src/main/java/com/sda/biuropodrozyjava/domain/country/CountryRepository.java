package com.sda.biuropodrozyjava.domain.country;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByNameLike(String name);

    List<Country> findByContinent_Id(Long id);

}
