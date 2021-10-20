package com.sda.biuropodrozyjava.web.controllers;

import com.sda.biuropodrozyjava.domain.travel.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final TravelService travelService;

    public HomeController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping
    public String start(Model model) {
        model.addAttribute("travels", travelService.getPromoted());
        return "index";
    }

}
