
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.ApplicationContext;

public interface ApplicationContextRepo extends JpaRepository<ApplicationContext, UUID> {
    
    
}
