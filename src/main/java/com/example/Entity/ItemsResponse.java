package com.example.Entity;

import com.example.DTO.AmountRequestDTO;
import com.example.DTO.RecipientNameResponseDTO;

public class ItemsResponse {
        private String payoutItemId;
        private String transactionId;
        private String activityId;
        private String payoutBatchId;
        private String timeProcessed;
        private Links links;
        private String transactionStatus;
        private AmountResponse amount;
    
        public String getPayoutItemId() {
            return payoutItemId;
        }
    
        public void setPayoutItemId(String payoutItemId) {
            this.payoutItemId = payoutItemId;
        }
    
        public String getTransactionId() {
            return transactionId;
        }
    
        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
    
}

        public String getActivityId() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getActivityId'");
        }

        public String getPayoutBatchId() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getPayoutBatchId'");
        }

        public String getSenderBatchId() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getSenderBatchId'");
        }

        public String getTimeProcessed() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getTimeProcessed'");
        }

        public String getRecipientType() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRecipientType'");
        }

        public String getNote() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getNote'");
        }

        public String getReceiver() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getReceiver'");
        }

        public AmountRequestDTO getAmount() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getAmount'");
        }

        public String getTransactionStatus() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getTransactionStatus'");
        }

        public void setActivityId(String string) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setActivityId'");
        }

        public void setTimeProcessed(String string) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setTimeProcessed'");
        }

        public void setSenderBatchId(String string) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setSenderBatchId'");
        }

        public void setReceiver(String string) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setReceiver'");
        }

        public void setRecipientType(String string) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setRecipientType'");
        }

        public void setNote(String string) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setNote'");
        }

        public void setAmount(AmountResponse amount2) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setAmount'");
        }

        public void setTransactionStatus(String string) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setTransactionStatus'");
        }

        public String getSenderItemId() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getSenderItemId'");
        }

        public String getRecipientWallet() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRecipientWallet'");
        }

        public String getPurpose() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getPurpose'");
        }

        public RecipientNameResponseDTO getRecipientName() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRecipientName'");
        }
}