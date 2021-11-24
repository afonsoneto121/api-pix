package com.example.transfer.stream;

import com.example.transfer.exception.NotFound;
import com.example.transfer.schema.TransactionAvro;
import com.example.transfer.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class StreamingConfig {
    private final TransactionService service;
    @Bean
    public Consumer<TransactionAvro> transactionProcess() {
        return (input) -> {
            try {
                service.updateTransaction(input.getId(),input.getStatus(), input.getProcessed());
            } catch (NotFound e) {
                e.printStackTrace();
            }
        };
    }
}
