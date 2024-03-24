package com.intern.fooddelivery.controller;

import com.intern.fooddelivery.dto.CalculatedFeeDTO;
import com.intern.fooddelivery.dto.StationDTO;
import com.intern.fooddelivery.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/calculate_fee")
    public CalculatedFeeDTO calculateDeliveryFee(@RequestParam String vehicle, @RequestParam String city){
        System.out.println(vehicle + " " + city);
        return stationService.calculateFee(vehicle, city);
    }

    @GetMapping("/allweather")
    public List<StationDTO> getAllStationData(){
        return stationService.getAllStationData();
    }
}