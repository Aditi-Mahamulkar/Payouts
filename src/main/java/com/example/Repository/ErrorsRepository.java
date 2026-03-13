

package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Errors;

public interface ErrorsRepository extends JpaRepository<Errors, UUID> {
    
    
}
