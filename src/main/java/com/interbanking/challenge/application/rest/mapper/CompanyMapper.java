package com.interbanking.challenge.application.rest.mapper;


import com.interbanking.challenge.application.request.CompanyRequest;
import com.interbanking.challenge.application.response.CompanyResponse;
import com.interbanking.challenge.application.response.CompanyTransferenceResponse;
import com.interbanking.challenge.application.response.TransferenceResponse;
import com.interbanking.challenge.domain.entity.CompanyEntity;
import com.interbanking.challenge.domain.entity.TransferenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper( CompanyMapper.class );
    CompanyEntity companyRequestToEntity(CompanyRequest companyRequest);
    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
    CompanyResponse companyEntityToResponse(CompanyEntity companyEntity);

    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
    CompanyTransferenceResponse companyEntityAndTransferenceEntityToResponse(CompanyEntity companyEntity);

    TransferenceResponse companyTransferencesToResponse(TransferenceEntity transferenceEntity);
}
