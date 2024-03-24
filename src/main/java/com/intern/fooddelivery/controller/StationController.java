package com.intern.fooddelivery.controller;

import com.intern.fooddelivery.dto.CalculatedFeeDTO;
import com.intern.fooddelivery.dto.StationDTO;
import com.intern.fooddelivery.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * Handles the station entities which contain weather data and also the calculation requests
 */
@RestController
public class StationController {

    @Autowired
    private StationService stationService;

    /**
     * handles the request for the fee calculation
     * @param vehicle vehicle type
     * @param city city of delivery
     * @param date optional date parameter in the form of "yyyy-MM-dd""
     * @param time optional time paramtere in the form of "hh:mm:ss"
     * @return the Calculated fee DTO from the service level
     * @throws ParseException since the date and time are parsed on the service level, there might be exceptions thrown
     */
    @GetMapping("/calculate_fee")
    public CalculatedFeeDTO calculateDeliveryFee(@RequestParam String vehicle, @RequestParam String city, @RequestParam Optional<String> date, @RequestParam Optional<String> time) throws ParseException {
        System.out.println(vehicle + " " + city);
        return stationService.calculateFee(vehicle, city, date, time);
    }

    /**
     * method for receiving all of the weather data in database
     * @return List of the station dtos containing the weather data by stations and timestamps
     */
    @GetMapping("/allweather")
    public List<StationDTO> getAllStationData(){
        return stationService.getAllStationData();
    }
}