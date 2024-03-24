package com.intern.fooddelivery.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CalculatedFeeDTO {
    private Long id;
    private double fee;
    private String error;
}
