package com.intern.fooddelivery.service;

import com.intern.fooddelivery.dto.CalculatedFeeDTO;
import org.springframework.stereotype.Service;

@Service
public interface StationServive {
        public CalculatedFeeDTO calculateFee(String vehicle, String city);


}
