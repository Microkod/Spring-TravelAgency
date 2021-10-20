package com.sda.biuropodrozyjava.domain.continent;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentService {
    ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public List<Continent> getAll() {
        return continentRepository.findAll();
    }
}
