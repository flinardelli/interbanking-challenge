package com.interbanking.challenge.domain.service;


import com.interbanking.challenge.domain.entity.CompanyEntity;
import com.interbanking.challenge.domain.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    @Test
    void getAllByLastMonth() {
        var companyEntity1 = CompanyEntity.builder()
                .id(UUID.randomUUID())
                .businessName("Interbanking")
                .cuit("300035523")
                .createdAt(LocalDateTime.now())
                .build();

        var companyEntity2 = CompanyEntity.builder()
                .id(UUID.randomUUID())
                .businessName("Santander")
                .cuit("300035523")
                .createdAt(LocalDateTime.now().minusMonths(1))
                .build();

        var companyEntity3 = CompanyEntity.builder()
                .id(UUID.randomUUID())
                .businessName("Banco Naci{on")
                .cuit("300035523")
                .createdAt(LocalDateTime.now().minusMonths(3))
                .build();

        List<CompanyEntity> companies = new ArrayList<>();
        companies.add(companyEntity1);
        companies.add(companyEntity2);

        Mockito.when(companyRepository.findAllByCreatedAtGreaterThanEqual(Mockito.any())).thenReturn(companies);
        var companyEntities = companyService.getAllByLastMonth();

        assertNotNull(companyEntities);
        assertEquals(2, companyEntities.size());
    }
}