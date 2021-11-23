package com.example.transfer.config;

import com.example.transfer.entity.Transaction;
import com.example.transfer.schema.TransactionAvro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class StreamingConfig {
/*
    @Bean
    public Function<Transaction, TransactionAvro> transactionCreated() {
        return (save) ->  TransactionAvro.newBuilder()
                .setId(save.getId())
                .setPixKeySender(save.getKeyPixSender())
                .setPixKeyReceiver(save.getKeyPixReceiver())
                .setValue(save.getValue())
                .setStatus(save.isStatus())
                .setProcessed(save.isStatus())
                .build();
    }
     @Bean
    public Consumer<Transaction> transactionCreated() {
        return (save) -> TransactionAvro.newBuilder()
                .setId(save.getId())
                .setPixKeySender(save.getKeyPixSender())
                .setPixKeyReceiver(save.getKeyPixReceiver())
                .setValue(save.getValue())
                .setStatus(save.isStatus())
                .setProcessed(save.isStatus())
                .build();
    }
    @Bean
    public Function<Transaction, TransactionAvro> transactionCreated() {
        return (save) -> TransactionAvro.newBuilder()
                .setId(save.getId())
                .setPixKeySender(save.getKeyPixSender())
                .setPixKeyReceiver(save.getKeyPixReceiver())
                .setValue(save.getValue())
                .setStatus(save.isStatus())
                .setProcessed(save.isStatus()).build();
    }*/
}
