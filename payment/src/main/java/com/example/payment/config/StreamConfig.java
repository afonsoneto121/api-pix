package com.example.payment.config;

import com.example.payment.entity.Transaction;
import com.example.transfer.schema.TransactionAvro;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class StreamConfig {
//    @Bean
//    public Consumer<KStream<Object,TransactionAvro> > transactionCreated() {
//        return ( (input) -> {
//            input.foreach(((key, value) -> System.out.println("receive " + value.getId())));
//        });
//    }
    @Bean
    public Consumer<TransactionAvro> transactionCreated() {
        return ( (input) -> {
            System.out.println("receive " + input);
        });
    }
}
