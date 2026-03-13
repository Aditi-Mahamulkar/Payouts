

package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {
    
    
}
