package com.interbanking.challenge.domain.repository;

import com.interbanking.challenge.domain.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public interface CompanyRepository extends CrudRepository<CompanyEntity, UUID> {
    Set<CompanyEntity> findAllByCreatedAtGreaterThanEqual(LocalDateTime lastMonth);
    Set<CompanyEntity> findAllByTransferencesCreatedAtGreaterThanEqual(LocalDateTime lastMonth);
}
