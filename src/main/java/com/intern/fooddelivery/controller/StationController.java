package com.intern.fooddelivery.controller;

import com.intern.fooddelivery.dto.CalculatedFeeDTO;
import com.intern.fooddelivery.dto.StationDTO;
import com.intern.fooddelivery.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/calculate_fee")
    public CalculatedFeeDTO calculateDeliveryFee(@RequestParam String vehicle, @RequestParam String city, @RequestParam Optional<String> date, @RequestParam Optional<String> time) throws ParseException {
        System.out.println(vehicle + " " + city);
        return stationService.calculateFee(vehicle, city, date, time);
    }

    @GetMapping("/allweather")
    public List<StationDTO> getAllStationData(){
        return stationService.getAllStationData();
    }
}