package com.intern.fooddelivery.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="weather_by_stations")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station")
    private String station;

    @Column(name = "wmo")
    private Long wmo;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "windspeed")
    private Double windspeed;

    @Column(name = "phenomenon")
    private String phenomenon;

    @Column(name = "timestamp")
    private String timestamp;
}
