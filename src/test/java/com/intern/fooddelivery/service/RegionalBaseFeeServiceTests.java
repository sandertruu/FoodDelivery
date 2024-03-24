package com.intern.fooddelivery.service;

import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.model.RegionalBaseFee;
import com.intern.fooddelivery.repository.RegionalBaseFeeRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.mockito.Mockito.when;

//Kahjuks ei saanud hakkama ka service testidega
@ExtendWith(MockitoExtension.class)
public class RegionalBaseFeeServiceTests {
    @Mock
    private RegionalBaseFeeRepo regionalBaseFeeRepo;

    @InjectMocks
    private RegionalBaseFeeServiceImpl regionalBaseFeeService;

//    @Test
//    public void RBFService_GetAllBaseFees(){
//        Page<RegionalBaseFee> baseFees = Mockito.mock(Page.class);
//
//        when(regionalBaseFeeRepo.findAll(Mockito.any(Pageable.class))).thenReturn(baseFees);
//
//        List<RegionalBaseFeeDTO> baseFeeDTOS = regionalBaseFeeService.getAllBaseFees();
//
//        Assertions.assertThat(baseFeeDTOS).isNotNull();
//    }
//
//    @Test
//    public void RBFService_AddFee_ReturnsString(){
//        RegionalBaseFeeDTO rbf1 = RegionalBaseFeeDTO.builder().city("Tallinn")
//                .vehicle("bike").fee(3).build();
//
//        String savedMessage = regionalBaseFeeService.addBaseFee(rbf1);
//
//        Assertions.assertThat(savedMessage).isNotNull();
//    }
//
//    @Test
//    public void RBFService_UpdateFee_ReturnsString(){
//        RegionalBaseFee rbf1 = RegionalBaseFee.builder().city("Tallinn")
//                .vehicle("bike").fee(3).build();
//        regionalBaseFeeRepo.save(rbf1);
//
//        String savedMessage = regionalBaseFeeService.updateBaseFee("Tallinn", "bike", 3.5);
//
//        Assertions.assertThat(savedMessage).isNotNull();
//
//        RegionalBaseFee updated = regionalBaseFeeRepo.findById(rbf1.getId()).get();
//        Assertions.assertThat(updated.getFee()).isEqualTo(3.5);
//    }
}
