
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Links;

public interface LinksRepository extends JpaRepository<Links, UUID> {
    
    
}
