package com.intern.fooddelivery.service;

import com.intern.fooddelivery.business.FeeCalculator;
import com.intern.fooddelivery.dto.CalculatedFeeDTO;
import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.dto.StationDTO;
import com.intern.fooddelivery.model.CalculatedFee;
import com.intern.fooddelivery.model.RegionalBaseFee;
import com.intern.fooddelivery.model.Station;
import com.intern.fooddelivery.repository.CalculatedFeeRepo;
import com.intern.fooddelivery.repository.RegionalBaseFeeRepo;
import com.intern.fooddelivery.repository.StationRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationRepo stationRepo;
    @Autowired
    private RegionalBaseFeeRepo regionalBaseFeeRepo;
    @Autowired
    private CalculatedFeeRepo calculatedFeeRepo;
    @Autowired
    private ModelMapper modelMapper;




    @Override
    public CalculatedFeeDTO calculateFee(String vehicle, String city) {
        StationDTO weather = null;
        List<Station> stations= stationRepo.findAll();
        List<StationDTO> stationDTOS = stations.stream().
                map(station -> modelMapper.map(station, StationDTO.class)).collect(Collectors.toList());
        for (StationDTO station : stationDTOS) {
            if (station.getStation().equals(city)){
                weather = station;
                break;
            }
        }
        RegionalBaseFeeDTO rbf = null;
        List<RegionalBaseFee> rbfs = regionalBaseFeeRepo.findAll();
        System.out.println(rbfs);
        List<RegionalBaseFeeDTO> rbfsDTOS = rbfs.stream().
                map(regionalBaseFee -> modelMapper.map(regionalBaseFee, RegionalBaseFeeDTO.class)).collect(Collectors.toList());
        for (RegionalBaseFeeDTO rbfdata : rbfsDTOS) {
            if (rbfdata.getCity().equals(city) && rbfdata.getVehicle().equals(vehicle)){
                System.out.println(vehicle + " " + city);
                rbf = rbfdata;
                break;
            }
        }

        FeeCalculator feeCalculator = new FeeCalculator(vehicle, rbf.getFee(), weather.getTemperature(), weather.getWindspeed(), weather.getPhenomenon());

        CalculatedFeeDTO calculatedFeeDTO = feeCalculator.calulateFee();

        calculatedFeeRepo.save(modelMapper.map(calculatedFeeDTO, CalculatedFee.class));

        return calculatedFeeDTO;
    }

    @Override
    public List<StationDTO> getAllStationData() {
        return stationRepo.findAll().stream()
                .map(station -> modelMapper.map(station, StationDTO.class)).collect(Collectors.toList());
    }


}
