package com.example.DTO;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data; 
@Data
@AllArgsConstructor
public class createRequestDTO {
   
    private ItemsRequestDTO items;
      @JsonProperty("sender_batch_header")
    private SenderBatchHeaderRequestDTO senderBatchHeader;
    
}