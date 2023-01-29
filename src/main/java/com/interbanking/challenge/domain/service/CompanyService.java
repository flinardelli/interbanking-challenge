package com.interbanking.challenge.domain.service;

import com.interbanking.challenge.domain.entity.CompanyEntity;
import com.interbanking.challenge.domain.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public CompanyEntity create(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    /**
     * Get all companies by last month
     * @author Federico Linardelli
     */
    public Set<CompanyEntity> getAllByLastMonth() {
        LocalDateTime lastMonth = getLastMonth();

        return companyRepository.findAllByCreatedAtGreaterThanEqual(lastMonth);
    }

    /**
     * Get all companies that made transfers in the last month
     * @author Federico Linardelli
     */
    public Set<CompanyEntity> getAllByTransferenceLastMonth() {
        LocalDateTime lastMonth = getLastMonth();

        return companyRepository.findAllByTransferencesCreatedAtGreaterThanEqual(lastMonth);
    }

    /**
     * Method that obtain the last month
     * @author Federico Linardelli
     */
    private LocalDateTime getLastMonth() {
        LocalDate lastMonthDate = LocalDate.now();
        LocalTime lastMonthTime = LocalTime.of(0, 0, 0, 0);
        return LocalDateTime.of(lastMonthDate, lastMonthTime).minusMonths(1);
    }
}
