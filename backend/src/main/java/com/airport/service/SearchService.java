package com.airport.service;

import com.airport.dto.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private GeoDBApiService geoDBApiService;

    public CityDTO askCoordinates(CityDTO cityDTO) {

        CityDTO resultCity = geoDBApiService.findPopulatedPlaces(cityDTO);
        System.out.println(resultCity); // log out result

        geoDBApiService.printNumOfAllResult();
        return resultCity;
    }
}
