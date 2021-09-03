package com.example.transfer.resources;

import com.example.transfer.dto.request.TransactionDTORequest;
import com.example.transfer.dto.response.TransactionDTOResponse;
import com.example.transfer.entity.Transaction;
import com.example.transfer.exception.NotFound;
import com.example.transfer.mapper.TransactionMapper;
import com.example.transfer.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/transaction")
@RequiredArgsConstructor
public class TransactionResource {
    private final TransactionMapper transactionMapper;
    private final TransactionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDTOResponse saveTransaction(@RequestBody @Valid TransactionDTORequest dtoRequest) {
        Transaction transactionToSave = transactionMapper.DTORequestToModel(dtoRequest);
        return transactionMapper.ModelToDTOResponse(service.save(transactionToSave));
    }
    @GetMapping
    public TransactionDTOResponse findById(@RequestParam String id) throws NotFound {
        Transaction transaction = service.findById(id);
        return transactionMapper.ModelToDTOResponse(transaction);
    }
}
