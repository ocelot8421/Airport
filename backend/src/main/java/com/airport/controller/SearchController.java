package com.airport.controller;

import com.airport.dto.CityDTO;
import com.airport.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    // http://localhost:8081/search/city
    @PostMapping(path = "/city",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public CityDTO searchCity(
            @RequestBody CityDTO cityDTO
    ) {
        return searchService.askCoordinates(cityDTO);
    }
}
