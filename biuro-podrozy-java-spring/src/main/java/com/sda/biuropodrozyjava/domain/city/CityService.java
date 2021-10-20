package com.sda.biuropodrozyjava.domain.city;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getByCountryId(Long id) {
        return cityRepository.findByCountry_Id(id);
    }

    public void addCity(City city) {
        cityRepository.save(city);
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }
}
