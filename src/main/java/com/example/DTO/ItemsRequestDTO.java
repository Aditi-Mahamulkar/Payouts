package com.example.DTO;

import lombok.Data;

@Data
public class ItemsRequestDTO {

    private String recipient_type;
    private String note;
    private String receiver;
    private String sender_item_id;
    private String recipient_wallet;

    private AmountRequestDTO amount;

    private AlternateNotificationMethodRequestDTO alternate_notification_method;

    private String notification_language;

    private ApplicationContextRequestDTO application_context;

    private String purpose;
}