package com.example.DTO;

import lombok.Data;
import java.util.List;

@Data
public class ItemsResponseDTO {

    private String payout_item_id;
    private String transaction_id;
    private String activity_id;
    private String time_processed;

    private List<LinkResponseDTO> links;

    private String transaction_status;

    private PayoutItemFeesResponseDTO payout_item_fee;

    private PayoutItemResponseDTO payout_item;

    private CurrencyConversionResponseDTO currency_conversion;
}