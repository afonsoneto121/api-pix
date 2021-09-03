package com.example.transfer.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
public class TransactionDTORequest{

    @NotBlank
    private String keyPixSender;

    @Min(value = 0)
    private Float value;

    @NotBlank
    private String keyPixReceiver;

}
