package com.example.DTO;


import lombok.Data;
import java.util.UUID;

@Data
public class FromAmountResponseDTO {

    private UUID id;
    private String currency;
    private String value;
}