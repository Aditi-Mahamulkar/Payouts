
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.AlternateNotificationMethod;

public interface AlternateNotificationMethodRepository extends JpaRepository<AlternateNotificationMethod, UUID> {
    
    
}
