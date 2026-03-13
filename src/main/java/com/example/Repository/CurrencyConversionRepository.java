

package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.CurrencyConversion;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, UUID> {
    
    
}
