package com.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationContextRequestDTO {

    private String socialFeedPrivacy;
    private String hollerUrl;
    private String logoUrl;
}