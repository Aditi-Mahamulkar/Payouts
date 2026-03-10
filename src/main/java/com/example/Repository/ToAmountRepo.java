
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.ToAmount;

public interface ToAmountRepo extends JpaRepository<ToAmount, UUID> {
    
    
}
