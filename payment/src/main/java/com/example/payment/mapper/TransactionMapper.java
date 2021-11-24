package com.example.payment.mapper;

import com.example.payment.entity.Transaction;
import com.example.transfer.schema.TransactionAvro;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction avroToTransaction(TransactionAvro avro) {
        return Transaction.builder()
                .id(avro.getId())
                .keyPixSender(avro.getPixKeySender())
                .keyPixReceiver(avro.getPixKeyReceiver())
                .value(avro.getValue())
                .status(avro.getStatus())
                .processed(avro.getProcessed())
                .build();
    }

    public TransactionAvro transactionToAvro(Transaction transaction) {
        return TransactionAvro.newBuilder()
                .setId(transaction.getId())
                .setPixKeySender(transaction.getKeyPixSender())
                .setPixKeyReceiver(transaction.getKeyPixReceiver())
                .setValue(transaction.getValue())
                .setStatus(transaction.isStatus())
                .setProcessed(transaction.isProcessed())
                .build();
    }
}
