

package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.SenderBatchHeader;

public interface SenderBatchHeaderRepository extends JpaRepository<SenderBatchHeader, UUID> {
    
    
}
