package com.intern.fooddelivery.service;

import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.model.RegionalBaseFee;
import com.intern.fooddelivery.repository.RegionalBaseFeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * logic for the service level handling of the base fees
 */
@Service
public class RegionalBaseFeeServiceImpl implements RegionalBaseFeeService{

    @Autowired
    private RegionalBaseFeeRepo regionalBaseFeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * allows to add a new base fee through the REST interface
     * @param regionalBaseFeeDTO the DTO for the base fee containing city, vehicle type and fee value
     * @return message of success
     */
    @Override
    public String addBaseFee(RegionalBaseFeeDTO regionalBaseFeeDTO) {
        regionalBaseFeeRepo.save(modelMapper.map(regionalBaseFeeDTO, RegionalBaseFee.class));
        return "Base fee added!";
    }

    /**
     * method for updating the base fees through REST interface
     * @param city the city for the base fee
     * @param vehicle vehicle for the base fee
     * @param fee new fee value
     * @return message of success
     */
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

    /**
     * method for deleting a base fee based on the city and vehicle type
     * @param city city for which we want to delete the fee
     * @param vehicle vehicle type for which we want to delete the fee
     * @return message of success
     */
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

    /**
     * method for getting all the base fee information
     * @return list of the base fee DTOs
     */
    @Override
    public List<RegionalBaseFeeDTO> getAllBaseFees() {
        return regionalBaseFeeRepo.findAll().stream()
                .map(regionalBaseFee -> modelMapper.map(regionalBaseFee, RegionalBaseFeeDTO.class)).collect(Collectors.toList());
    }


}
