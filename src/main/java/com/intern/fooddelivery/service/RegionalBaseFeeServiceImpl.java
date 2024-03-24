package com.intern.fooddelivery.service;

import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.model.RegionalBaseFee;
import com.intern.fooddelivery.repository.RegionalBaseFeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public String updateBaseFee(String city, String vehicle, double fee) {
        List<RegionalBaseFee> rbfs = regionalBaseFeeRepo.findAll();
        for (RegionalBaseFee rbf : rbfs) {
            if(rbf.getVehicle().equals(vehicle) && rbf.getCity().equals(city)){
                RegionalBaseFee updated = rbf;
                updated.setFee(fee);
                regionalBaseFeeRepo.save(updated);
            }
        }
        return "Base fee updated!";
    }

    @Override
    public String deleteBaseFee(String city, String vehicle) {
        List<RegionalBaseFee> rbfs = regionalBaseFeeRepo.findAll();
        for (RegionalBaseFee rbf : rbfs) {
            if(rbf.getVehicle().equals(vehicle) && rbf.getCity().equals(city)){
                regionalBaseFeeRepo.delete(rbf);
            }
        }
        return "Base fee deleted!";
    }

    @Override
    public List<RegionalBaseFeeDTO> getAllBaseFees() {
        return regionalBaseFeeRepo.findAll().stream()
                .map(regionalBaseFee -> modelMapper.map(regionalBaseFee, RegionalBaseFeeDTO.class)).collect(Collectors.toList());
    }


}
