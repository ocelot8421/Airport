package com.airport.service;

import com.airport.dto.CityDTO;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    //GeoDbApiClient apiClient = new GeoDbApiClient(GeoDbInstanceType.FREE);

    public CityDTO askCoordinates(CityDTO cityDTO){
        System.out.println("Teszt teszt");
        return new CityDTO();
    }
}
