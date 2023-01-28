package com.interbanking.challenge.application.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class TransferenceResponse {
    private UUID id;
    private Float amount;
    private LocalDateTime createdAt;
    private String creditAccount;
    private String debitAccount;
}
