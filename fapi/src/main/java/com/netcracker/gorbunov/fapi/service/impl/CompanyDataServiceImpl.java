package com.netcracker.gorbunov.fapi.service.impl;

import com.netcracker.gorbunov.fapi.beClasses.CompanyModel;
import com.netcracker.gorbunov.fapi.models.CompanyViewModel;
import com.netcracker.gorbunov.fapi.service.CompanyDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CompanyDataServiceImpl implements CompanyDataService {


    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public List<CompanyViewModel> getAllCompanies() {
        RestTemplate restTemplate = new RestTemplate();
        CompanyViewModel[] companyViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/companies/", CompanyViewModel[].class);
        return companyViewModelResponse == null ? Collections.emptyList() : Arrays.asList(companyViewModelResponse);
    }

    @Override
    public CompanyViewModel getCompanyById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/companies/" + id, CompanyViewModel.class);
    }

    @Override
    public CompanyViewModel saveCompany(CompanyViewModel companyViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/companies/add", companyViewModel, CompanyViewModel.class).getBody();
    }

    @Override
    public void deleteCompany(Integer id) {

    }
}
