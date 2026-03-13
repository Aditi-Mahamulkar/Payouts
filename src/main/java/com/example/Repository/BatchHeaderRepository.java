
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.BatchHeader;

public interface BatchHeaderRepository extends JpaRepository<BatchHeader, UUID> {
    
    
}
