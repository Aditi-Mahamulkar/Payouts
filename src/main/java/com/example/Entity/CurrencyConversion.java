package com.example.Entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "currency_conversion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String exchangeRate;

    @OneToOne
    @JoinColumn(name = "from_amount_id")
    private FromAmount fromAmount;

    @OneToOne
    @JoinColumn(name = "to_amount_id")
    private ToAmount toAmount;
}
