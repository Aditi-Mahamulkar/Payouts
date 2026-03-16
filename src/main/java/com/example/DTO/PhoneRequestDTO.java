package com.example.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhoneRequestDTO {

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("national_number")
    private String nationalNumber;

}