package com.wander.userservice.covid19.controller;

import com.wander.userservice.covid19.service.CovidDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CovidController {

    private final CovidDataService covidDataService;

    @GetMapping("/covid")
    public String sayHello(Model model) {
        model.addAttribute("covidData", covidDataService.getCovidData());

        return "covid";
    }
}
