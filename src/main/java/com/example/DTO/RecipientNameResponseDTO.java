package com.example.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RecipientNameResponseDTO {

  private String prefix;
  private String givenName;
  private String surname;
  private String middleName;
  private String suffix;
  private String alternateFullName;
  private String fullName;
}
