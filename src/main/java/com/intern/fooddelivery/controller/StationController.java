package com.intern.fooddelivery.controller;

import com.intern.fooddelivery.dto.CalculatedFeeDTO;
import com.intern.fooddelivery.model.Station;
import com.intern.fooddelivery.repository.StationRepo;
import com.intern.fooddelivery.service.StationServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StationController {

    @Autowired
    private StationServive stationServive;

    @GetMapping("calculate_fee")
    public CalculatedFeeDTO calculateDeliveryFee(@RequestParam String vehicle, @RequestParam String city){
        return stationServive.calculateFee(vehicle, city);
    }
}
