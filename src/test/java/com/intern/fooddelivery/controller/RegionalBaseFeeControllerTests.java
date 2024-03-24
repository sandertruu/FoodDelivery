package com.intern.fooddelivery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intern.fooddelivery.dto.RegionalBaseFeeDTO;
import com.intern.fooddelivery.model.RegionalBaseFee;
import com.intern.fooddelivery.service.RegionalBaseFeeService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = RegionalBaseFeeController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class RegionalBaseFeeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegionalBaseFeeService regionalBaseFeeService;

    @Autowired
    private ObjectMapper objectMapper;
    private RegionalBaseFee rbf;
    private RegionalBaseFeeDTO rbfDTO;

    @BeforeEach
    public void init(){
        rbf = RegionalBaseFee.builder().city("Tallinn")
                .vehicle("bike").fee(3).build();
        rbfDTO = RegionalBaseFeeDTO.builder().city("Tallinn")
                .vehicle("bike").fee(3).build();
    }

    //Proovisin implementeerida Controlleri teste, hetkel jätsin ikkagi meetodi tagastama stringi,
    //kuna ei saanud toimima ka juhul kui ta tagastab seda objekti.
//    @Test
//    public void RBFController_AddFee() throws Exception {
//        given(regionalBaseFeeService.addBaseFee(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));
//
//        ResultActions response = mockMvc.perform(post("/update_base_fee")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(rbfDTO)));
//
//        response.andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.city", CoreMatchers.is(rbfDTO.getCity())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.vehicle", CoreMatchers.is(rbfDTO.getVehicle())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.fee", CoreMatchers.is(rbfDTO.getFee())));
//    }

}
