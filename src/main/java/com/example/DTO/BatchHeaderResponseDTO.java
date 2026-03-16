package com.example.DTO;

import org.hibernate.boot.model.internal.FetchSecondPass;

import lombok.Data;

@Data

public class BatchHeaderResponseDTO {

  private String payoutBatchId;
  private String timeCreated;
  //private String timeCompleted;
  //private String timeClosed;
  private String batchStatus;

  private SenderBatchHeaderResponseDTO senderBatchHeader;

  //private String fundingSource;

  //private AmountRequestDTO amount;
 // private FeesResponseDTO fees;
 // public String getSenderBatchId;

}
