package com.sda.biuropodrozyjava.web.controllers;

import com.sda.biuropodrozyjava.domain.continent.Continent;
import com.sda.biuropodrozyjava.domain.continent.ContinentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/continents")
@Slf4j
public class ContinentRestController {
    private final ContinentService continentService;

    public ContinentRestController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping
    public List<Continent> getAll() {
        return continentService.getAll();
    }
}
