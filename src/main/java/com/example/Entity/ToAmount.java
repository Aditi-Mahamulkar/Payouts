package com.example.Entity;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "to_amount")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "value")
    private String value;
}
