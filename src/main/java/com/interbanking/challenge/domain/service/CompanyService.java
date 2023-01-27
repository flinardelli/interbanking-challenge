package com.interbanking.challenge.domain.service;

import com.interbanking.challenge.application.request.CompanyRequest;
import com.interbanking.challenge.domain.entity.CompanyEntity;
import com.interbanking.challenge.domain.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public CompanyEntity create(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    public List<CompanyEntity> getAll() {
        return companyRepository.findAll();
    }
}
