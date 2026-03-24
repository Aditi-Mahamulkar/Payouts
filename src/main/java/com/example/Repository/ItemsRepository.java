
package com.example.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.ItemsRequest;
import com.example.Entity.ItemsResponse;

public interface ItemsRepository extends JpaRepository<ItemsRequest, UUID> {

    Object findByPayoutItemId(String payoutItemId);

    Object findBySenderItemId(String payout_Item_Id);

    void save(ItemsResponse item);
    
    
}
