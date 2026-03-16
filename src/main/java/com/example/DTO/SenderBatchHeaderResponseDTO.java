
package com.example.DTO;

import lombok.Data;

@Data

public class SenderBatchHeaderResponseDTO {
    
  private String senderBatchId;
  private String emailSubject;
  private String emailMessage;
  private String recipientType;
  //private String note;
    
}
