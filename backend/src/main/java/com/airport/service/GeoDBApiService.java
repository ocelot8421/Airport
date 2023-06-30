package com.airport.service;

import com.airport.dto.CityDTO;
import com.wirefreethought.geodb.client.GeoDbApi;
import com.wirefreethought.geodb.client.model.*;
import com.wirefreethought.geodb.client.net.GeoDbApiClient;
import com.wirefreethought.geodb.client.request.FindPlacesRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Implements GeoDBApiClient. Also gets coordinates.
 *
 * @note: Some city have more than five results.
 * To get only one result, it is needed to use a unique id (in this case wikiDataID).
 * It could accuse error (outside of the test city names) if we search a city that is not in the five most populated cities.
 * This is because the getData() function presents only five results.
 * @see: <a href="https://github.com/wirefreethought/geodb-java-client">github -- geodb-java-client</a> and
 * <a href="http://geodb-cities-api.wirefreethought.com/docs/api/find-places">geodb-cities-api.wirefreethought.com</a>
 */

@Service
public class GeoDBApiService {

    private String citiName;
    private Metadata metadata;

    public CityDTO findPopulatedPlaces(CityDTO cityDTO) {

        citiName = cityDTO.getName();
        GeoDbApiClient apiClient = new GeoDbApiClient(GeoDbInstanceType.FREE);
        GeoDbApi geoDbApi = new GeoDbApi(apiClient);

        // Presents only 5 results sorted in ascending order
        PopulatedPlacesResponse placesResponse = geoDbApi.findPlaces(
                FindPlacesRequest.builder()
                        .namePrefix(cityDTO.getName())
                        .sort(
                                GeoDbSort.builder()
                                        .fields(new GeoDbSort.SortField[]{
                                                new GeoDbSort.SortField(PlaceSortFields.FindPlaces.POPULATION, true)
                                        })
                                        .build())
                        .build()
        );

        // To manipulate the printing of metadata
        metadata = placesResponse.getMetadata();

        return findCoordinates(placesResponse, cityDTO);
    }

    private CityDTO findCoordinates(PopulatedPlacesResponse placesResponse, CityDTO cityDTO) {
        for (PopulatedPlaceSummary summary : Objects.requireNonNull(placesResponse.getData())) {
            if (Objects.equals(summary.getWikiDataId(), cityDTO.getWikiDataId())) {
                cityDTO.setLongitude(summary.getLongitude());
                cityDTO.setLatitude(summary.getLatitude());
            }
        }
        return cityDTO;
    }

    public void printNumOfAllResult() {
        System.out.println("(Number of search results for '" + citiName + "': " + metadata.getTotalCount() + " )"); // log out the number of all results
    }
}
