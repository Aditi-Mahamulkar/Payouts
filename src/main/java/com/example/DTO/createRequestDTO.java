package com.example.DTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data; 
@Data
@AllArgsConstructor
public class createRequestDTO {
   
    private ItemsRequestDTO items;
    private SenderBatchHeaderRequestDTO senderBatchHeader;
    
}