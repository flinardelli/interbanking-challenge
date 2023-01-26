package com.interbanking.challenge.application.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Builder
public class CompanyRequest {
    private UUID id;
    @NotBlank
    private String cuit;
    @NotBlank
    private String businessName;
}
