
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Fees;

public interface FeesRepo extends JpaRepository<Fees, UUID> {
    
    
}
