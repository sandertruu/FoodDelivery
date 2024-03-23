package com.intern.fooddelivery.controller;

import com.intern.fooddelivery.repository.RegionalBaseFeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionalBaseFeeController {
    @Autowired
    RegionalBaseFeeRepo regionalBaseFeeRepo;
}
