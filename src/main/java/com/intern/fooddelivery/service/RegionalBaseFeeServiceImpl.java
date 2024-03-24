package com.intern.fooddelivery.service;

import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.model.RegionalBaseFee;
import com.intern.fooddelivery.repository.RegionalBaseFeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.Optional;

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

    @Override
    public String updateBaseFee(Long id, RegionalBaseFeeDTO regionalBaseFeeDTO) {
        Optional<RegionalBaseFee> regionalBaseFee = regionalBaseFeeRepo.findById(id);
        if (regionalBaseFee.isPresent()){
            RegionalBaseFee updated = regionalBaseFee.get();
            updated.setCity(regionalBaseFeeDTO.getCity());
            updated.setFee(regionalBaseFeeDTO.getFee());
            updated.setVehicle(regionalBaseFeeDTO.getVehicle());
            regionalBaseFeeRepo.save(updated);
        }
        return "Base fee updated!";
    }
}
