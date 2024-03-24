package com.intern.fooddelivery.service;

import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.model.RegionalBaseFee;
import org.springframework.stereotype.Service;

@Service
public interface RegionalBaseFeeService {
    public String addBaseFee(RegionalBaseFeeDTO regionalBaseFeeDTO);

    public String updateBaseFee(String city, String vehicle, double fee);

    public String deleteBaseFee(String city, String vehicle);
}
