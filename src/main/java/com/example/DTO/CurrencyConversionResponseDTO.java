package com.example.DTO;

import lombok.Data;

@Data

public class CurrencyConversionResponseDTO {

  private String exchangeRate;
  private FromAmountResponseDTO fromAmount;
  private ToAmountResponseDTO toAmount;
}
