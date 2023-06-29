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
    private Long  latitude;     //szélesség(i kör)
    private Long  longitude;    //hosszúság(i kör)

    @Override
    public String toString() {
        return "CityDTO{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", wikiDataId=" + wikiDataId +
                '}';
    }
}
