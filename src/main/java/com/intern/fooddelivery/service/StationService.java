package com.intern.fooddelivery.service;

import com.intern.fooddelivery.dto.CalculatedFeeDTO;
import com.intern.fooddelivery.dto.StationDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public interface StationService {
        public CalculatedFeeDTO calculateFee(String vehicle, String city, Optional<String> date, Optional<String> time) throws ParseException;

        public List<StationDTO> getAllStationData();
}
