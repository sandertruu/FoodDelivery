package com.intern.fooddelivery.service;

import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.model.RegionalBaseFee;
import com.intern.fooddelivery.repository.RegionalBaseFeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Service
public class RegionalBaseFeeServiceImpl implements RegionalBaseFeeService{

    @Autowired
    private RegionalBaseFeeRepo regionalBaseFeeRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String addBaseFee(RegionalBaseFeeDTO regionalBaseFeeDTO) {
        regionalBaseFeeRepo.save(modelMapper.map(regionalBaseFeeDTO, RegionalBaseFee.class));
        return "Base fee added!";
    }
}
