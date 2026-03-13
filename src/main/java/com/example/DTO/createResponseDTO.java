package com.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class createResponseDTO {

    private LinkResponseDTO links;
    private BatchHeaderResponseDTO batchHeader;
}