package com.example.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CurrencyConversionResponseDTO {

  private String exchangeRate;
  private AmountRequestDTO fromAmount;
  private AmountRequestDTO toAmount;
}
