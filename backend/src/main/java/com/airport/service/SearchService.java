package com.airport.service;

import com.airport.dto.CityDTO;
import com.wirefreethought.geodb.client.model.PopulatedPlaceSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private GeoDBApiService geoDBApiService;

    public CityDTO askCoordinates(CityDTO cityDTO) {
        PopulatedPlaceSummary summary = geoDBApiService.findPopulatedPlaces(cityDTO);

        // null check
        saveCoordinates(summary, cityDTO);
        System.out.println(cityDTO); // log out result

        geoDBApiService.printNumOfAllResult();
        return cityDTO;
    }

    private void saveCoordinates(PopulatedPlaceSummary summary, CityDTO cityDTO) {
        String errorMsg;
        if (summary == null) {
            errorMsg = "No result of searching in GeoDB.";
            cityDTO.setError(errorMsg);
            System.out.println(errorMsg);
        } else {
            errorMsg = "City found!";
            cityDTO.setError(errorMsg);
            System.out.println(errorMsg);
            cityDTO.setLongitude(summary.getLongitude());
            cityDTO.setLatitude(summary.getLatitude());
        }
    }
}
