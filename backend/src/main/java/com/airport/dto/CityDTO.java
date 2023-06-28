package com.airport.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CityDTO {

    private String name;
    private Long  latitude;     //szélesség(i kör)
    private Long  longitude;    //hosszúság(i kör)
}
