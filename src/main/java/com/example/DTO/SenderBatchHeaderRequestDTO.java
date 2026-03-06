package com.example.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SenderBatchHeaderRequestDTO {

  private String senderBatchId;
  private String emailSubject;
  private String emailMessage;
  private String recipientType;
}
