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

import javax.swing.plaf.synth.Region;
import java.util.List;

public class StationServiceImpl implements StationServive{
    @Autowired
    private StationRepo stationRepo;
    @Autowired
    private RegionalBaseFeeRepo regionalBaseFeeRepo;
    @Autowired
    private CalculatedFeeRepo calculatedFeeRepo;
    @Autowired
    ModelMapper modelMapper;

    StationDTO weather;
    RegionalBaseFeeDTO rbf;

    @Override
    public CalculatedFeeDTO calculateFee(String vehicle, String city) {
        List<Station> stations= stationRepo.findAll();
        for (Station station : stations) {
            if (station.getStation().equals(city)){
                weather = modelMapper.map(station, StationDTO.class);
                break;
            }
        }
        List<RegionalBaseFee> rbfs = regionalBaseFeeRepo.findAll();
        for (RegionalBaseFee rbfdata : rbfs) {
            if (rbfdata.getCity().equals(city)){
                rbf = modelMapper.map(rbfdata, RegionalBaseFeeDTO.class);
            }
        }

        FeeCalculator feeCalculator = new FeeCalculator(vehicle, rbf.getFee(), weather.getTemperature(), weather.getWindspeed(), weather.getPhenomenon());

        CalculatedFeeDTO calculatedFeeDTO = feeCalculator.calulateFee();

        calculatedFeeRepo.save(modelMapper.map(calculatedFeeDTO, CalculatedFee.class));

        return calculatedFeeDTO;
    }


}
