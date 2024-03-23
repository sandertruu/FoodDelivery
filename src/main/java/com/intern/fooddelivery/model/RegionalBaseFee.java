package com.intern.fooddelivery.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "regional_base_fee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegionalBaseFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "vehicle")
    private String vehicle;

    @Column(name = "fee")
    private double fee;
}
