package com.netcracker.gorbunov.fapi.controller;


import com.netcracker.gorbunov.fapi.models.CompanyViewModel;
import com.netcracker.gorbunov.fapi.service.CompanyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyDataController {


    @Autowired
    private CompanyDataService companyDataService;


    @GetMapping
    public ResponseEntity<List<CompanyViewModel>> getAllCompanies() {
        return ResponseEntity.ok(companyDataService.getAllCompanies());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<CompanyViewModel> saveCompany(@RequestBody CompanyViewModel companyViewModel /*todo server validation*/) {
        if (companyViewModel != null) {
            return ResponseEntity.ok(companyDataService.saveCompany(companyViewModel));
        }
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCompany(@PathVariable Integer id) {
        companyDataService.deleteCompany(Integer.valueOf(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyViewModel> getCompanyById(@PathVariable Integer id) {
        Integer companyId = Integer.valueOf(id);
        return ResponseEntity.ok(companyDataService.getCompanyById(companyId));
    }

}
