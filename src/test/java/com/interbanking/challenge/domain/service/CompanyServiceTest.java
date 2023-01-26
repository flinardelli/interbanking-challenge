package com.interbanking.challenge.domain.service;


import com.interbanking.challenge.domain.entity.CompanyEntity;
import com.interbanking.challenge.domain.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

    private CompanyRepository companyRepository;
    private CompanyService companyService;

    @BeforeEach
    void setUp() {
        companyRepository = Mockito.mock(CompanyRepository.class);
        companyService = new CompanyService(companyRepository);
    }

    @Test
    void create() {
        var companyEntity = CompanyEntity.builder()
                .id(UUID.randomUUID())
                .businessName("Interbanking")
                .cuit("300035523")
                .build();

        Mockito.when(companyRepository.save(Mockito.any())).thenReturn(companyEntity);
        var companyEntityResponse = companyService.create(companyEntity);

        assertNotNull(companyEntityResponse);
        assertNotNull(companyEntityResponse.getId());
        assertEquals(companyEntity.getCuit(), companyEntityResponse.getCuit());
        assertEquals(companyEntity.getBusinessName(), companyEntityResponse.getBusinessName());
    }
}