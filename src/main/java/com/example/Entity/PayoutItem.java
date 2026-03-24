package com.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "payout_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayoutItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "note")
    private String note;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "sender_item_id")
    private String senderItemId;

    @Column(name = "recipient_type")
    private String recipientType;

    @Column(name = "recipient_wallet")
    private String recipientWallet;

    @Column(name = "purpose")
    private String purpose;

    @OneToOne
    @JoinColumn(name = "amount_id")
    private AmountRequest amount;

    @OneToOne
    @JoinColumn(name = "recipient_name_id")
    private RecipientName recipientName;
}