
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.RecipientName;

public interface RecipientNameRepository extends JpaRepository<RecipientName, UUID> {
    
    
}
