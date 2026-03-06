package com.example.Entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recipient_name")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipientName {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;
    @Column(name = "prefix")
    private String prefix;
    @Column(name = "given_name")
    private String given_name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "middle_name")
    private String middle_name;
    @Column(name = "suffix")
    private String suffix;
    @Column(name = "alternate_full_name")
    private String alternate_full_name;
    @Column(name = "full_name")
    private String full_name;
}
