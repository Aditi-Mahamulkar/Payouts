
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.PayoutItemfee;

public interface PayoutItemfeeRepository extends JpaRepository<PayoutItemfee, UUID> {
    
    
}
