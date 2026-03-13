package com.example.DTO;

import lombok.Data;

@Data

public class BatchHeaderResponseDTO {

  private String payoutBatchId;
  private String timeCreated;
  private String timeCompleted;
  private String timeClosed;
  private String batchStatus;

  private SenderBatchHeaderRequestDTO senderBatchHeader;

  private String fundingSource;

  private AmountRequestDTO amount;
  private AmountRequestDTO fees;
  public String getSenderBatchId;

}
