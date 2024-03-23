package com.intern.fooddelivery.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class StationDTO {

    private Long id;

    private String station;

    private String wmo;

    private Double temperature;

    private Double windspeed;

    private String phenomenon;

    private String timestamp;
}
