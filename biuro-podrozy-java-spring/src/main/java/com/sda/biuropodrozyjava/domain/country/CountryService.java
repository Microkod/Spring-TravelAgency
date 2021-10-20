package com.sda.biuropodrozyjava.domain.country;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findByName(String name) {
        return countryRepository.findByNameLike(name);
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public List<Country> getByContinentId(Long id) {
        return countryRepository.findByContinent_Id(id);
    }
}
