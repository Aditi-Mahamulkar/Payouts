package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.AmountRequest;

public interface AmountRepository extends JpaRepository<AmountRequest, UUID> {
    
    
}
