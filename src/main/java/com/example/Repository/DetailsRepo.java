

package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Details;

public interface DetailsRepo extends JpaRepository<Details, UUID> {
    
    
}
