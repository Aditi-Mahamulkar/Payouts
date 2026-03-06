package com.example.Entity;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Payout_Item_fee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayoutItemfee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "value")
    private String value;
}
