package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.models.CompanyViewModel;

import java.util.List;

public interface CompanyDataService {
    List<CompanyViewModel> getAllCompanies();
    CompanyViewModel getCompanyById(Integer id);
    CompanyViewModel saveCompany(CompanyViewModel companyViewModel);
    void deleteCompany(Integer id);
}
