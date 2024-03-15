package com.intern.fooddelivery.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="WeatherByStations")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String station;

    private Double temperature;

    private Double windspeed;

    private String phenomenon;

    private String timestamp;
}
