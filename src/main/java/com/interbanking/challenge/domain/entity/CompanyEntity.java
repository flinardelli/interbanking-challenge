package com.interbanking.challenge.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "companies")
@EntityListeners(AuditingEntityListener.class)
public class CompanyEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "cuit", nullable = false, unique = true)
    private String cuit;

    @Column(name = "business_name", nullable = false, unique = true, length = 50)
    private String businessName;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Set<TransferenceEntity> transferences = new HashSet<>();
}

