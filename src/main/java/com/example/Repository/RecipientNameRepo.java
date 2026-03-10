
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.RecipientName;

public interface RecipientNameRepo extends JpaRepository<RecipientName, UUID> {
    
    
}
