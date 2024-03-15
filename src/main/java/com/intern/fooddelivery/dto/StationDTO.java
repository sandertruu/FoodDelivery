package com.intern.fooddelivery.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class StationDTO {

    private Long id;

    private String station;

    private Double temperature;

    private Double windspeed;

    private String phenomenon;

    private String timestamp;
}
