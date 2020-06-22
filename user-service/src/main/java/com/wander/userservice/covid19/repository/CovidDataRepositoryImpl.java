package com.wander.userservice.covid19.repository;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Repository
public class CovidDataRepositoryImpl implements CovidDataRepository {

    private final static String COVID_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";

    @Override
    public String getCovidData() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(COVID_DATA_URL)).build();
        String covidData = "";

        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            covidData = httpResponse.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return covidData;
    }
}
