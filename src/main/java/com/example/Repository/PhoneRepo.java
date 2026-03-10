

package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Phone;

public interface PhoneRepo extends JpaRepository<Phone, UUID> {
    
    
}
