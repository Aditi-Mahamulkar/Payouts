package com.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ShowPayoutBatchResponseDTO {

    private Integer totalItems;
    private Integer totalPages;

    private List<PayoutItemResponseDTO> items;

    private ErrorResponseDTO errors;

    private List<LinkResponseDTO> links;

    private BatchHeaderResponseDTO batchHeader;
}