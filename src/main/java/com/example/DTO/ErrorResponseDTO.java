package com.example.DTO;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ErrorResponseDTO {

    private String name;
    private String message;
    private String debugId;
    private String informationLink;

    private List<DetailsResponseDTO> details;
    private List<LinkResponseDTO> links;
}
