package com.interbanking.challenge.domain.service;


import com.interbanking.challenge.domain.entity.CompanyEntity;
import com.interbanking.challenge.domain.entity.TransferenceEntity;
import com.interbanking.challenge.domain.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

    private CompanyRepository companyRepository;
    private CompanyService companyService;

    private CompanyEntity companyEntity1;
    private CompanyEntity companyEntity2;

    @BeforeEach
    void setUp() {
        companyRepository = Mockito.mock(CompanyRepository.class);
        companyService = new CompanyService(companyRepository);

        this.companyEntity1 = CompanyEntity.builder()
                .id(UUID.randomUUID())
                .businessName("Interbanking")
                .cuit("300035523")
                .createdAt(LocalDateTime.now())
                .build();

        this.companyEntity2 = CompanyEntity.builder()
                .id(UUID.randomUUID())
                .businessName("Santander")
                .cuit("305135523")
                .createdAt(LocalDateTime.now().minusMonths(1))
                .build();
    }

    @Test
    void create() {
        companyEntity1.setCreatedAt(null);
        Mockito.when(companyRepository.save(Mockito.any())).thenReturn(companyEntity1);
        var companyEntityResponse = companyService.create(companyEntity1);

        assertNotNull(companyEntityResponse);
        assertNotNull(companyEntityResponse.getId());
        assertEquals(companyEntity1.getCuit(), companyEntityResponse.getCuit());
        assertEquals(companyEntity1.getBusinessName(), companyEntityResponse.getBusinessName());
    }
    @Test
    void getAllByLastMonth() {
        Set<CompanyEntity> companies = new HashSet<>();
        companies.add(companyEntity1);
        companies.add(companyEntity2);

        Mockito.when(companyRepository.findAllByCreatedAtGreaterThanEqual(Mockito.any())).thenReturn(companies);
        var companyEntities = companyService.getAllByLastMonth();

        assertNotNull(companyEntities);
        assertEquals(2, companyEntities.size());
    }

    @Test
    void getAllByTransferenceLastMonth() {
        var transference1 = TransferenceEntity.builder()
                .id(UUID.randomUUID())
                .amount(215050.8f)
                .creditAccount(3000225)
                .debitAccount(null)
                .createdAt(LocalDateTime.now().minusMonths(2))
                .build();

        var transference2 = TransferenceEntity.builder()
                .id(UUID.randomUUID())
                .amount(255000.8f)
                .creditAccount(3000225)
                .debitAccount(null)
                .createdAt(LocalDateTime.now().minusMonths(1))
                .build();

        Set<TransferenceEntity> transferences = new HashSet<>();
        transferences.add(transference1);
        transferences.add(transference2);
        companyEntity1.setTransferences(transferences);

        Set<CompanyEntity> companies = new HashSet<>();
        companies.add(companyEntity1);
        companies.add(companyEntity2);

        Mockito.when(companyRepository.findAllByTransferencesCreatedAtGreaterThanEqual(Mockito.any())).thenReturn(companies);
        var companyEntities = companyService.getAllByLastMonth();

        assertNotNull(companyEntities);
    }
}