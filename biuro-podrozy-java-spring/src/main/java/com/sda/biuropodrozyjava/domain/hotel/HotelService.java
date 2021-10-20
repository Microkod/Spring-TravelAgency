package com.sda.biuropodrozyjava.domain.hotel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> findByName(String name) {
        return hotelRepository.findByNameLike(name);
    }

    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }
}
