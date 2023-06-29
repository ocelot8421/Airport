package com.airport.service;

import com.airport.dto.CityDTO;
import com.wirefreethought.geodb.client.GeoDbApi;
import com.wirefreethought.geodb.client.model.GeoDbInstanceType;
import com.wirefreethought.geodb.client.model.PopulatedPlaceResponse;
import com.wirefreethought.geodb.client.model.PopulatedPlacesResponse;
import com.wirefreethought.geodb.client.net.GeoDbApiClient;
import com.wirefreethought.geodb.client.request.FindPlacesRequest;
import com.wirefreethought.geodb.client.request.GetPlaceRequest;
import com.wirefreethought.geodb.client.request.PlaceRequestType;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GeoDBApiService {

    public CityDTO receiveCoordinates(CityDTO cityDTO) {
        //TODO Paris is not registered as city but admin division. The correct solution should get the country also that is from frontend.
        GeoDbApiClient apiClient = new GeoDbApiClient(GeoDbInstanceType.FREE);

        GeoDbApi geoDbApi = new GeoDbApi(apiClient);

//        PopulatedPlaceResponse result = geoDbApi.getPlace(
//                GetPlaceRequest.builder()
//                        .placeId("3453089")
//                        .build()
//        );
//        System.out.println("result.getData():");
//        System.out.println(result.getData());

        PopulatedPlacesResponse placesResponse = geoDbApi.findPlaces(
                FindPlacesRequest.builder()
                        .namePrefix(cityDTO.getName())
                        .build()
        );


        System.out.println("placesResponse.getData():");
        System.out.println(placesResponse.getData());
//        System.out.println(placesResponse.getLinks());
        System.out.println(placesResponse.getMetadata());


        return cityDTO;
    }

}
