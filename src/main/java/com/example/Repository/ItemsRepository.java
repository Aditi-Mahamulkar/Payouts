
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Items;

public interface ItemsRepository extends JpaRepository<Items, UUID> {
    
    
}
