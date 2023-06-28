package com.airport.service;

import com.airport.dto.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private GeoDBApiService geoDBApiService;

    public CityDTO askCoordinates(CityDTO cityDTO) {
        System.out.println(" - - - cityDTO: " + cityDTO);
        CityDTO resultCity = geoDBApiService.receiveCoordinates(cityDTO);
        System.out.println("resultCity" + resultCity);
        return resultCity;
    }
}
