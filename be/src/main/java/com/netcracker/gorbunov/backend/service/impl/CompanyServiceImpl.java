package com.netcracker.gorbunov.backend.service.impl;

import com.netcracker.gorbunov.backend.entity.CompaniesEntity;
import com.netcracker.gorbunov.backend.repository.CompanyRepository;
import com.netcracker.gorbunov.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository){
        this.repository = repository;
    }


    @Override
    public CompaniesEntity saveCompany(CompaniesEntity companiesEntity) {
        return repository.save(companiesEntity);
    }

    @Override
    public Optional<CompaniesEntity> getCompanyById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<CompaniesEntity> getAllCompanies() {
        return repository.findAll();
    }

    @Override
    public void deleteCompany(Integer id) {
        repository.deleteById(id);
    }
}
