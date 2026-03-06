package com.example.DTO;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlternateNotificationMethodRequestDTO {

    private UUID id;
    private PhoneRequestDTO phone;
}