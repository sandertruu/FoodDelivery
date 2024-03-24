package com.intern.fooddelivery.service;

import com.intern.fooddelivery.dto.CalculatedFeeDTO;
import com.intern.fooddelivery.dto.StationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StationService {
        public CalculatedFeeDTO calculateFee(String vehicle, String city);

        public List<StationDTO> getAllStationData();
}
