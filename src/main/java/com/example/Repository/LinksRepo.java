
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Links;

public interface LinksRepo extends JpaRepository<Links, UUID> {
    
    
}
