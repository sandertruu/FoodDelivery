package com.intern.fooddelivery.controller;

import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.service.RegionalBaseFeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegionalBaseFeeController {
    @Autowired
    private RegionalBaseFeeService regionalBaseFeeService;

    @PostMapping("/add_base_fee")
    public String addBaseFee(@RequestBody RegionalBaseFeeDTO regionalBaseFeeDTO){

        return regionalBaseFeeService.addBaseFee(regionalBaseFeeDTO);
    };

    @PostMapping("/update_base_fee")
    public String updateBaseFee(@RequestParam String city, @RequestParam String vehicle, @RequestParam double fee){
        return regionalBaseFeeService.updateBaseFee(city, vehicle, fee);
    }

    @DeleteMapping
    public String deleteBaseFee(@RequestParam String city, @RequestParam String vehicle){
        return regionalBaseFeeService.deleteBaseFee(city, vehicle);
    }

    @GetMapping("/allbasefees")
    public List<RegionalBaseFeeDTO> getAllBaseFees(){
        return regionalBaseFeeService.getAllBaseFees();
    }

}
