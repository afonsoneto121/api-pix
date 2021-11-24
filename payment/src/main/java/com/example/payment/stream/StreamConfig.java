package com.example.payment.stream;

import com.example.payment.mapper.TransactionMapper;
import com.example.payment.service.TransactionService;
import com.example.transfer.schema.TransactionAvro;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class StreamConfig {
    private final TransactionService service;
    private final TransactionMapper mapper;
    @Bean
    public Function<TransactionAvro, TransactionAvro> transactionCreated() {
        return ( (input) -> mapper.transactionToAvro(
                service.transfer(input)
        ));
    }
}
