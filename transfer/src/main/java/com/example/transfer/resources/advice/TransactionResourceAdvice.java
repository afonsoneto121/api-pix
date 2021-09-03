package com.example.transfer.resources.advice;

import com.example.transfer.dto.Message;
import com.example.transfer.exception.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TransactionResourceAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFound.class)
    public Message notFound() {
        return Message.builder().message("Resource not found").build();
    }
}
