package com.example.Entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "batch_header")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "payout_batch_id")
    private String payoutBatchId;

    @Column(name = "time_created")
    private OffsetDateTime timeCreated;

    @Column(name = "batch_status")
    private String batchStatus;

     @OneToOne
    @JoinColumn(name = "sender_batch_header_id")
    private SenderBatchHeader sender_batch_header;
}
