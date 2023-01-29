package com.interbanking.challenge.application.rest;

import com.interbanking.challenge.application.request.CompanyRequest;
import com.interbanking.challenge.application.response.CompanyResponse;
import com.interbanking.challenge.application.response.CompanyTransferenceResponse;
import com.interbanking.challenge.application.rest.mapper.CompanyMapper;
import com.interbanking.challenge.domain.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyMapper companyMapper;
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyMapper = CompanyMapper.INSTANCE;
        this.companyService = companyService;
    }

    @PostMapping
    @ApiOperation(value = "Create new company", notes = "Returns a new object created")
    @ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Created") })
    public ResponseEntity<CompanyResponse> create (@Valid @RequestBody CompanyRequest companyRequest) {
        var companyEntity = companyService.create(companyMapper.companyRequestToEntity(companyRequest));
        var companyResponse = companyMapper.companyEntityToResponse(companyEntity);
        return new ResponseEntity<>(companyResponse, HttpStatus.CREATED);
    }

    @GetMapping("/last-month")
    @ApiOperation(value = "Get all companies created by last month", notes = "Returns all companies created by last month")
    @ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK") })
    public ResponseEntity<List<CompanyResponse>> getAllByLastMonth () {
        var companiesEntity = companyService.getAllByLastMonth();
        var companies = companiesEntity.stream().map(companyMapper::companyEntityToResponse).collect(Collectors.toList());
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/transferences/last-month")
    @ApiOperation(value = "Get all companies that made transfers in the last month", notes = "Returns all companies that made transfers in the last month")
    @ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK") })
    public ResponseEntity<List<CompanyTransferenceResponse>> getAllByTransferenceLastMonth () {
        var companiesEntity = companyService.getAllByTransferenceLastMonth();
        var companies = companiesEntity.stream().map(companyMapper::companyEntityAndTransferenceEntityToResponse).collect(Collectors.toList());
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }
}
