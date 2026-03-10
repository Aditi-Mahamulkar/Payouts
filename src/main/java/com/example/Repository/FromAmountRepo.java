
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.FromAmount;

public interface FromAmountRepo extends JpaRepository<FromAmount, UUID> {
    
    
}
