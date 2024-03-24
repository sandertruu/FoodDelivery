package com.intern.fooddelivery.controller;

import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.service.RegionalBaseFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionalBaseFeeController {
    @Autowired
    private RegionalBaseFeeService regionalBaseFeeService;

    @PostMapping("/add_base_fee")
    public String addBaseFee(@RequestBody RegionalBaseFeeDTO regionalBaseFeeDTO){

        return regionalBaseFeeService.addBaseFee(regionalBaseFeeDTO);
    };

    @PostMapping("/update_base_fee/{city}")
    public String updateBaseFee(@PathVariable Long id, @RequestBody RegionalBaseFeeDTO regionalBaseFeeDTO){
        return regionalBaseFeeService.updateBaseFee(id, regionalBaseFeeDTO);
    }

}
