package com.intern.fooddelivery.repository;

import com.intern.fooddelivery.model.CalculatedFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatedFeeRepo extends JpaRepository<CalculatedFee, Long> {
}
