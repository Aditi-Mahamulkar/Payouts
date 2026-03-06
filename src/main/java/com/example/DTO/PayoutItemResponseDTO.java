package com.example.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PayoutItemResponseDTO {

  private String note;
  private String receiver;
  private String senderItemId;
  private String recipientType;

  private AmountRequestDTO amount;

  private RecipientNameResponseDTO recipientName;

  private String recipientWallet;
  private String purpose;
} 
