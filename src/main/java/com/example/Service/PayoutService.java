package com.example.Service;

import com.example.DTO.CancelResponseDTO;
import com.example.DTO.ItemsRequestDTO;
import com.example.DTO.ShowPayoutBatchResponseDTO;
import com.example.DTO.ShowPayoutItemResponseDTO;
import com.example.DTO.createRequestDTO;
import com.example.DTO.createResponseDTO;

public interface PayoutService {

    createResponseDTO createPayout(createRequestDTO requestDTO);

    // ShowPayoutBatchResponseDTO  getBatchDetails(String payout_batch_Id);

    ShowPayoutItemResponseDTO getPayoutItemDetails(String payout_Item_Id);
    
   // CancelResponseDTO cancelPayout(String payout_Item_Id);

}