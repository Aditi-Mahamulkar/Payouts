package com.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

import com.example.Entity.Links;

@Data
@AllArgsConstructor
public class CancelResponseDTO {

    public CancelResponseDTO() {
        //TODO Auto-generated constructor stub
    }

    private String payoutItemId;
    private String transactionId;
    private String activityId;
    private String payoutBatchId;
    private String senderBatchId;
    private String timeProcessed;

    private LinkResponseDTO links;

    private String transactionStatus;

    private AmountResponseDTO payoutItemFee;

    private PayoutItemResponseDTO payoutItem;

    private CurrencyConversionResponseDTO currencyConversion;

    private ErrorResponseDTO errors;

    public void setLinks(Links links2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLinks'");
    }
}