package com.example.payment.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Transaction {
        @Id
        private String id;
        private String keyPixSender;
        private Float value;
        private String keyPixReceiver;
        private boolean status;
        private boolean processed;

    }
