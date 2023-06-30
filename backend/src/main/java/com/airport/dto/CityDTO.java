package com.airport.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CityDTO {

    private String name;
    private String wikiDataId;
    private Double latitude;     //szélesség(i kör)
    private Double longitude;    //hosszúság(i kör)
    private String error;

    @Override
    public String toString() {
        return "result: \n --- " + name + " ---\n" +
                "latitude: " + latitude + ", longitude: " + longitude + "\n" +
                "wikiDataId: " + wikiDataId;
    }
}
