
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.ApplicationContext;

public interface ApplicationContextRepository extends JpaRepository<ApplicationContext, UUID> {
    
    
}
