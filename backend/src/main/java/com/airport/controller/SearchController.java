package com.airport.controller;

import com.wirefreethought.geodb.client.model.GeoDbInstanceType;
import com.wirefreethought.geodb.client.net.GeoDbApiClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/search")
public class SearchController {

//    GeoDbApiClient apiClient = new GeoDbApiClient(GeoDbInstanceType.FREE);
    GeoDbApiClient apiClient = new GeoDbApiClient(GeoDbInstanceType.FREE);
}
