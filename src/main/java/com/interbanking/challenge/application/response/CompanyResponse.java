package com.interbanking.challenge.application.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CompanyResponse {
    private UUID id;
    private String cuit;
    private String businessName;
    private LocalDateTime createdAt;
}
