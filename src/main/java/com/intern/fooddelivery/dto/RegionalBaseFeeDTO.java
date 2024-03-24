package com.intern.fooddelivery.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RegionalBaseFeeDTO {

    private Long id;

    private String city;

    private String vehicle;

    private double fee;
}
