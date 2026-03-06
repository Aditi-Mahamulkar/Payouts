package com.example.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "application_context")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationContext {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "social_feed_privacy")
    private String socialFeedPrivacy;

    @Column(name = "holler_url", columnDefinition = "TEXT")
    private String hollerUrl;

    @Column(name = "logo_url", columnDefinition = "TEXT")
    private String logoUrl;
}
