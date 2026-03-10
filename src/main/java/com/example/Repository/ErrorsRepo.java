

package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Errors;

public interface ErrorsRepo extends JpaRepository<Errors, UUID> {
    
    
}
