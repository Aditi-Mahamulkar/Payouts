package com.example.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sender_batch_header")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SenderBatchHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "sender_batch_id")
    private String senderBatchId;

  //  @Column(name = "recipient_type")
   // private String recipientType;

    @Column(name = "email_subject")
    private String emailSubject;

    @Column(name = "email_message", columnDefinition = "TEXT")
    private String emailMessage;

   // @Column(name = "note", columnDefinition = "TEXT")
   // private String note;
}
