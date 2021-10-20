package com.sda.biuropodrozyjava.domain.travel;

import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TravelService {

    private final TravelRepository travelRepository;

    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public List<Travel> findAll(TravelSearchCriteria travelSearchCriteria) {
        TravelSpecification travelSpecification = new TravelSpecification(travelSearchCriteria);
        return travelRepository.findAll(travelSpecification);
    }

    public Travel getById(Long id) {
        return travelRepository.findById(id).orElseThrow();
    }

    public void addTravel(Travel travel) {
        travel.setNumberOfDays((int) ChronoUnit.DAYS.between(travel.getDepartureDate(), travel.getArrivalDate()) + 1);
        travelRepository.save(travel);
    }

    public List<Travel> getPromoted() {
        return travelRepository.getTravelByPromotedTrue();
    }

}
