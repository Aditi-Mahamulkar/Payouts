package com.example.Entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "errors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Errors {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String message;
    private String debug_id;
    private String information_link;
}
