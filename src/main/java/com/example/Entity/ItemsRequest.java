package com.example.Entity;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemsRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "recipient_type")
    private String recipientType;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "sender_item_id")
    private String senderItemId;

    @Column(name = "recipient_wallet")
    private String recipientWallet;

    @Column(name = "notification_language")
    private String notificationLanguage;

    @Column(name = "purpose")
    private String purpose;

    @OneToOne
    @JoinColumn(name = "amount_id")
    private AmountRequest amount;

    @OneToOne
    @JoinColumn(name = "alternate_notification_method_id")
    private AlternateNotificationMethod alternateNotificationMethod;

    @OneToOne
    @JoinColumn(name = "application_context_id")
    private ApplicationContext applicationContext;

    public void setPayoutItemId(String payout_item_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPayoutItemId'");
    }

    public void setTransactionId(String transaction_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTransactionId'");
    }

    public void setActivityId(String activity_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActivityId'");
    }

    public void payoutbatchid(String payoutBatchId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'payoutbatchid'");
    }

    public void setTimeProcessed(String time_processed) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTimeProcessed'");
    }

    public void transactionStatus(String transaction_status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transactionStatus'");
    }
}