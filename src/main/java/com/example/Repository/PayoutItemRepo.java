
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.PayoutItem;

public interface PayoutItemRepo extends JpaRepository<PayoutItem, UUID> {
    
    
}
