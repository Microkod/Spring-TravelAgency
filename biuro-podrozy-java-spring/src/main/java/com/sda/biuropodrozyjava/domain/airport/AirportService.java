package com.sda.biuropodrozyjava.domain.airport;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> findByName(String name) {
        return airportRepository.findByNameLike(name);
    }

    public void addAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public List<Airport> getAll() {
        return airportRepository.findAll();
    }
}
