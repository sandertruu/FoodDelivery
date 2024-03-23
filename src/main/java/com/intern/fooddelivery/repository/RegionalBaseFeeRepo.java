package com.intern.fooddelivery.repository;

import com.intern.fooddelivery.model.RegionalBaseFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionalBaseFeeRepo extends JpaRepository<RegionalBaseFee, Long> {
}
