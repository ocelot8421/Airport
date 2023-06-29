package com.airport.service;

import com.airport.dto.CityDTO;
import com.wirefreethought.geodb.client.GeoDbApi;
import com.wirefreethought.geodb.client.model.*;
import com.wirefreethought.geodb.client.net.GeoDbApiClient;
import com.wirefreethought.geodb.client.request.FindPlacesRequest;
import com.wirefreethought.geodb.client.request.GetPlaceRequest;
import com.wirefreethought.geodb.client.request.PlaceRequestType;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

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

//        PopulatedPlacesResponse placesResponse = geoDbApi.findPlaces(
//                FindPlacesRequest.builder()
//                        .namePrefix(cityDTO.getName())
//                        .build()
//        );
        PopulatedPlacesResponse placesResponse = geoDbApi.findPlaces(
                FindPlacesRequest.builder()
                        .namePrefix(cityDTO.getName())
                        .sort(
                                GeoDbSort.builder()
                                        .fields(new GeoDbSort.SortField[] {
                                                new GeoDbSort.SortField(PlaceSortFields.FindPlaces.POPULATION, true)
                                        })
                                        .build())
                        .build()
        );

        for (PopulatedPlaceSummary summary : Objects.requireNonNull(placesResponse.getData())) {
            if (Objects.equals(summary.getWikiDataId(), cityDTO.getWikiDataId())) {
                cityDTO.setLongitude(summary.getLongitude());
                cityDTO.setLatitude(summary.getLatitude());
                System.out.print("Match -> ");
            }
            System.out.println(summary.getName() + ", " + summary.getWikiDataId());
        }
        System.out.println(placesResponse.getMetadata());
        return cityDTO;
    }

}
