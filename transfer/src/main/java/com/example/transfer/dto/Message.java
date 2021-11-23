package com.example.transfer.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Builder
@Getter
public class Message {
    private String message;
}
