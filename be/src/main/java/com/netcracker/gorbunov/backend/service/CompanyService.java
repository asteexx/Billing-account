package com.netcracker.gorbunov.backend.service;

import com.netcracker.gorbunov.backend.entity.CompaniesEntity;

import java.util.Optional;

public interface CompanyService {

    CompaniesEntity saveCompany(CompaniesEntity companiesEntity);
    Optional<CompaniesEntity> getCompanyById(Integer id);
    Iterable<CompaniesEntity> getAllCompanies();
    void deleteCompany(Integer id);
}
