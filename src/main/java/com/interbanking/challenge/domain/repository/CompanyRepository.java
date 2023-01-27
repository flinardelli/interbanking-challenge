package com.interbanking.challenge.domain.repository;

import com.interbanking.challenge.domain.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    List<CompanyEntity> findAllByCreatedAtGreaterThanEqual(LocalDateTime lastMonth);
}
