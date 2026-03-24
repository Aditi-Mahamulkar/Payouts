package com.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ShowPayoutItemResponseDTO {

    public ShowPayoutItemResponseDTO() {
        //TODO Auto-generated constructor stub
    }

    private String payoutItemId;
    private String transactionId;
    private String activityId;
    private String payoutBatchId;
    private String senderBatchId;
    private String timeProcessed;

    private List<LinkResponseDTO> links;

    private String transactionStatus;

    private AmountResponseDTO payoutItemFee;

    private PayoutItemResponseDTO payoutItem;

    private CurrencyConversionResponseDTO currencyConversion;

    private ErrorResponseDTO errors;
}