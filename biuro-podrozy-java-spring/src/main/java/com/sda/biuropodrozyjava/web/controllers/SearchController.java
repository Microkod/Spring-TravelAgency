package com.sda.biuropodrozyjava.web.controllers;

import com.sda.biuropodrozyjava.domain.city.CityService;
import com.sda.biuropodrozyjava.domain.continent.ContinentService;
import com.sda.biuropodrozyjava.domain.country.CountryService;
import com.sda.biuropodrozyjava.domain.travel.TravelSearchCriteria;
import com.sda.biuropodrozyjava.domain.travel.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final ContinentService continentService;
    private final CountryService countryService;
    private final CityService cityService;
    private final TravelService travelService;

    public SearchController(ContinentService continentService, CountryService countryService, CityService cityService,
                            TravelService travelService) {
        this.continentService = continentService;
        this.countryService = countryService;
        this.cityService = cityService;
        this.travelService = travelService;
    }

    @GetMapping
    public String search(Model model) {
        model.addAttribute("continents", continentService.getAll());
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("searchCriteria", new TravelSearchCriteria());
        return "search";
    }

    @PostMapping
    public String postsAll(Model model, TravelSearchCriteria searchCriteria) {
        model.addAttribute("travels", travelService.findAll(searchCriteria));
        model.addAttribute("continents", continentService.getAll());
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("searchCriteria", searchCriteria);
        return "search";
    }
}
