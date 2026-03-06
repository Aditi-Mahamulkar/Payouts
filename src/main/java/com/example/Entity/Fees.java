package com.example.Entity;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fees {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String currency;

    private String value;
}
