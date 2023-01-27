package com.interbanking.challenge.application.rest.mapper;


import com.interbanking.challenge.application.request.CompanyRequest;
import com.interbanking.challenge.application.response.CompanyResponse;
import com.interbanking.challenge.domain.entity.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper( CompanyMapper.class );
    CompanyEntity companyRequestToEntity(CompanyRequest companyRequest);
    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
    CompanyResponse companyEntityToResponse(CompanyEntity companyResponse);
}
