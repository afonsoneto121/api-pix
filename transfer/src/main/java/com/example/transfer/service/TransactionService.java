package com.example.transfer.service;

import com.example.transfer.entity.Transaction;
import com.example.transfer.exception.NotFound;
import com.example.transfer.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository repository;

    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    public Transaction findById(String id) throws NotFound {
        return repository.findById(id).orElseThrow(() -> new NotFound());
    }
}
