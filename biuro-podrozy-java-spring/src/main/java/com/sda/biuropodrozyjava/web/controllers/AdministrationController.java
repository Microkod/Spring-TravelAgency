package com.sda.biuropodrozyjava.web.controllers;

import com.sda.biuropodrozyjava.Message;
import com.sda.biuropodrozyjava.domain.airport.Airport;
import com.sda.biuropodrozyjava.domain.airport.AirportService;
import com.sda.biuropodrozyjava.domain.city.City;
import com.sda.biuropodrozyjava.domain.city.CityService;
import com.sda.biuropodrozyjava.domain.country.CountryService;
import com.sda.biuropodrozyjava.domain.hotel.Hotel;
import com.sda.biuropodrozyjava.domain.hotel.HotelService;
import com.sda.biuropodrozyjava.domain.travel.OfferType;
import com.sda.biuropodrozyjava.domain.travel.Travel;
import com.sda.biuropodrozyjava.domain.travel.TravelService;
import com.sda.biuropodrozyjava.domain.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/add")
public class AdministrationController {

    private final TravelService travelService;
    private final UserService userService;
    private final CityService cityService;
    private final HotelService hotelService;
    private final AirportService airportService;
    private final CountryService countryService;


    public AdministrationController(TravelService travelService, UserService userService, CityService cityService,
                                    HotelService hotelService, AirportService airportService, CountryService countryService) {
        this.travelService = travelService;
        this.userService = userService;
        this.cityService = cityService;
        this.hotelService = hotelService;
        this.airportService = airportService;
        this.countryService = countryService;
    }

    @GetMapping("/airport")
    public String addAirport(Model model) {
        model.addAttribute("airport", new Airport());
        model.addAttribute("cities", cityService.getAll());
        return "administration/addairport";
    }

    @PostMapping("/airport")
    public String addAirport(Model model, @ModelAttribute Airport airport) {
        airportService.addAirport(airport);
        model.addAttribute("message", new Message("info", "Dodano lotnisko"));
        return "administration/added";
    }

    @GetMapping("/hotel")
    public String addHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("cities", cityService.getAll());
        return "administration/addhotel";
    }

    @PostMapping("/hotel")
    public String addHotel(Model model, @ModelAttribute Hotel hotel) {
        hotelService.addHotel(hotel);
        model.addAttribute("message", new Message("info", "Dodano hotel"));
        return "administration/added";
    }

    @GetMapping("/city")
    public String addCity(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("countries", countryService.getAll());
        return "administration/addcity";
    }

    @PostMapping("/city")
    public String addCity(Model model, @ModelAttribute City city) {
        cityService.addCity(city);
        model.addAttribute("message", new Message("info", "Dodano miasto"));
        return "administration/added";
    }

    @GetMapping("/travel")
    public String addTravel(Model model) {
        model.addAttribute("travel", new Travel());
        model.addAttribute("airports", airportService.getAll());
        model.addAttribute("hotels", hotelService.getAll());
        model.addAttribute("types", OfferType.values());
        return "administration/addtravel";
    }

    @PostMapping("/travel")
    public String addTravel(Model model, @ModelAttribute Travel travel) {
        travelService.addTravel(travel);
        model.addAttribute("message", new Message("info", "Dodano wycieczkę"));
        return "administration/added";
    }

}
