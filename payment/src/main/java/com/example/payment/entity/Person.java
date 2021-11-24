package com.example.payment.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Person {
    @Id
    private String id;
    private String name;

    @Column (unique = true)
    private String keyPix;
    private Float balance;
}
