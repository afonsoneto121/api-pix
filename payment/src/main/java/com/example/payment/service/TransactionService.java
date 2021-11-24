package com.example.payment.service;

import com.example.payment.entity.Person;
import com.example.payment.entity.Transaction;
import com.example.payment.mapper.TransactionMapper;
import com.example.payment.repository.PersonRepository;
import com.example.payment.repository.TransactionRepository;
import com.example.transfer.schema.TransactionAvro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final PersonRepository personRepository;
    private final TransactionMapper mapper;

    @Transactional
    public Transaction transfer(TransactionAvro avro) {
        Transaction transaction = mapper.avroToTransaction(avro);
        transaction.setProcessed(true);
        List<Person> people = personRepository.findAllById(
                Arrays.asList(
                        transaction.getKeyPixSender(),
                        transaction.getKeyPixReceiver()));

        if(people.size() != 2) { //There is any pix key invalid
            transaction.setStatus(false);
        } else {
            Person sender = people.get(0);
            Person receiver = people.get(1);

            if (avro.getValue() > sender.getBalance()) {//It's not possible transfer, because the balance is insufficient
                transaction.setStatus(false);
            } else {
                receiver.setBalance(receiver.getBalance() + avro.getValue());
                sender.setBalance(sender.getBalance() - avro.getValue());
                transaction.setStatus(true);

                personRepository.saveAll(Arrays.asList(sender,receiver));
                transactionRepository.save(transaction);
            }
        }
        return transaction;
    }
}
