package com.intern.fooddelivery.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "calculated_fee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CalculatedFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_fee")
    private double fee;

    @Column(name = "error_msg")
    private String error;
}
