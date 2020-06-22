package com.wander.userservice.covid19.service;

import com.wander.userservice.covid19.repository.CovidDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CovidDataServiceImpl implements CovidDataService {

    private final CovidDataRepository covidDataRepository;

    @Override
    public String getCovidData() {
        return covidDataRepository.getCovidData();
    }
}
