package com.intern.fooddelivery.controller;

import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.service.RegionalBaseFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing the Regional base fees through the REST endpoint
 */
@RestController
public class RegionalBaseFeeController {
    @Autowired
    private RegionalBaseFeeService regionalBaseFeeService;

    /**
     * Adds new base fee to the table
     * @param regionalBaseFeeDTO takes the base fee object, meaning vehicle, city and fee
     * @return message from the service level
     */
    @PostMapping("/add_base_fee")
    public String addBaseFee(@RequestBody RegionalBaseFeeDTO regionalBaseFeeDTO){

        return regionalBaseFeeService.addBaseFee(regionalBaseFeeDTO);
    };

    /**
     * allows to update the needed base fee with the exact city and vehicle type
     * @param city city name, which fee is to be updated
     * @param vehicle vehicle name, which fee is to be updated
     * @param fee value of the fee
     * @return message from the service level
     */
    @PostMapping("/update_base_fee")
    public String updateBaseFee(@RequestParam String city, @RequestParam String vehicle, @RequestParam double fee){
        return regionalBaseFeeService.updateBaseFee(city, vehicle, fee);
    }

    /**
     * Allows to delete a base fee entity according to the city and vehicle type
     * @param city given city
     * @param vehicle given vehicle type
     * @return message from the service level
     */
    @DeleteMapping
    public String deleteBaseFee(@RequestParam String city, @RequestParam String vehicle){
        return regionalBaseFeeService.deleteBaseFee(city, vehicle);
    }

    /**
     * shows all base fees from the database
     * @return list containing all the base fee dtos.
     */
    @GetMapping("/allbasefees")
    public List<RegionalBaseFeeDTO> getAllBaseFees(){
        return regionalBaseFeeService.getAllBaseFees();
    }

}
