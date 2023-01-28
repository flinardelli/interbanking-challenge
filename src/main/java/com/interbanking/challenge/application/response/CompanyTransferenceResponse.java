package com.interbanking.challenge.application.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class CompanyTransferenceResponse {
    private UUID id;
    private String cuit;
    private String businessName;
    private LocalDateTime createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<TransferenceResponse> transferences;
}
