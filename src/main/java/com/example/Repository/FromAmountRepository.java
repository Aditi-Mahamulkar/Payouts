
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.FromAmount;

public interface FromAmountRepository extends JpaRepository<FromAmount, UUID> {
    
    
}
