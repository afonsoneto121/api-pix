package com.example.transfer.service;

import com.example.transfer.entity.Transaction;
import com.example.transfer.exception.NotFound;
import com.example.transfer.repository.TransactionRepository;
import com.example.transfer.schema.TransactionAvro;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {
    private final TransactionRepository repository;

    private final StreamBridge streamBridge;

    public Transaction save(Transaction transaction) {
        Transaction save = repository.save(transaction);
        TransactionAvro avro = TransactionAvro.newBuilder()
                .setId(save.getId())
                .setPixKeySender(save.getKeyPixSender())
                .setPixKeyReceiver(save.getKeyPixReceiver())
                .setValue(save.getValue())
                .setStatus(save.isStatus())
                .setProcessed(save.isStatus())
                .build();
        Message<TransactionAvro> message = MessageBuilder.withPayload(avro)
                        .build();
       streamBridge.send("transactionCreated-out-0",message);
        return save;
    }

    public Transaction findById(String id) throws NotFound {
        return repository.findById(id).orElseThrow(() -> new NotFound());
    }

    public void updateTransaction(String id, boolean status, boolean process ) throws NotFound {
        Transaction transaction = findById(id);
        transaction.setStatus(status);
        transaction.setProcessed(process);
        repository.save(transaction);
    }

}
