package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Amount;

public interface AmountRepository extends JpaRepository<Amount, UUID> {
    
    
}
