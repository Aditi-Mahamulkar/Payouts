package com.example.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String field;

    private String value;

    private String location;

    private String issue;

    private String description;
}