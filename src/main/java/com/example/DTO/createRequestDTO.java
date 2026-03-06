package com.example.DTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data; 
@Data
@AllArgsConstructor
public class createRequestDTO {
   
    private List<ItemsRequestDTO> items;
    private SenderBatchHeaderRequestDTO senderBatchHeader;
    
}