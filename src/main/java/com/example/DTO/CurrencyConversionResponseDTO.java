package com.example.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;


import lombok.Data;

@Data

public class CurrencyConversionResponseDTO {

  private String exchangeRate;
  private AmountRequestDTO fromAmount;
  private AmountRequestDTO toAmount;
}
