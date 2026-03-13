

package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Details;

public interface DetailsRepository extends JpaRepository<Details, UUID> {
    
    
}
