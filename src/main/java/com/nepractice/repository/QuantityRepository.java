package com.nepractice.repository;

import com.nepractice.model.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityRepository extends JpaRepository<Quantity, Long> {
    // Additional custom methods can be defined here if needed
}