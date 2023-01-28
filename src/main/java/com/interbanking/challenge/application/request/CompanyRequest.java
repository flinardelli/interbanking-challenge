package com.interbanking.challenge.application.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
public class CompanyRequest {
    private UUID id;
    @NotBlank
    private String cuit;

    @NotBlank
    @Size(min = 3, max = 10)
    private String businessName;
}
