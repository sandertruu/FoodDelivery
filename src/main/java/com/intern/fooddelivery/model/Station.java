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
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "station")
    private String station;

    @Column(name = "wmo")
    private String wmo;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "windspeed")
    private Double windspeed;

    @Column(name = "phenomenon")
    private String phenomenon;

    @Column(name = "timestamp")
    private String timestamp;
}
