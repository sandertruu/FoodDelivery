package com.intern.fooddelivery.repository;

import com.intern.fooddelivery.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends JpaRepository<Station, Long> {
}
