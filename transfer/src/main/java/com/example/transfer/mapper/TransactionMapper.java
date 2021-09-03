package com.example.transfer.mapper;

import com.example.transfer.dto.request.TransactionDTORequest;
import com.example.transfer.dto.response.TransactionDTOResponse;
import com.example.transfer.entity.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionMapper {
    private final ObjectMapper objectMapper;

    public Transaction DTORequestToModel(TransactionDTORequest transactionDTORequest) {
        return objectMapper.convertValue(transactionDTORequest,Transaction.class);
    }
    public TransactionDTORequest ModelToDTORequest(Transaction transaction) {
        return objectMapper.convertValue(transaction,TransactionDTORequest.class);
    }
    public TransactionDTOResponse ModelToDTOResponse( Transaction transaction) {
        return TransactionDTOResponse.builder()
                .id(transaction.getId())
                .status(transaction.isStatus())
                .processed(transaction.isProcessed())
                .build();
    }
}
