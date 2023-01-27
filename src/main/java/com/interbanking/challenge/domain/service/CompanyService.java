package com.interbanking.challenge.domain.service;

import com.interbanking.challenge.domain.entity.CompanyEntity;
import com.interbanking.challenge.domain.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public CompanyEntity create(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    public List<CompanyEntity> getAllByLastMonth() {
        LocalDate lastMonthDate = LocalDate.now();
        LocalTime lastMonthTime = LocalTime.of(0, 0, 0, 0);
        LocalDateTime lastMonth = LocalDateTime.of(lastMonthDate, lastMonthTime).minusMonths(1);

        return companyRepository.findAllByCreatedAtGreaterThanEqual(lastMonth);
    }
}
