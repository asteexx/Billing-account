package com.netcracker.gorbunov.backend.controller;


import com.netcracker.gorbunov.backend.entity.CompaniesEntity;
import com.netcracker.gorbunov.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    private CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompaniesEntity> getCompanyById(@PathVariable(name = "id") Integer id) {
        Optional<CompaniesEntity> companiesEntity = companyService.getCompanyById(id);
        if (companiesEntity.isPresent()) {
            return ResponseEntity.ok(companiesEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "")
    public Iterable<CompaniesEntity> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping()
    public CompaniesEntity saveCompany(@RequestBody CompaniesEntity companiesEntity) {
        return companyService.saveCompany(companiesEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCompany(@PathVariable(name = "id") Integer id) {
        companyService.deleteCompany(id);
    }



}
