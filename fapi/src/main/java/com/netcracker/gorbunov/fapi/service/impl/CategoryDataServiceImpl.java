package com.netcracker.gorbunov.fapi.service.impl;

import com.netcracker.gorbunov.fapi.models.CategoryViewModel;
import com.netcracker.gorbunov.fapi.service.CategoryDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryDataServiceImpl implements CategoryDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public List<CategoryViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        CategoryViewModel[] categoryViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/categories/", CategoryViewModel[].class);
        return categoryViewModelResponse == null ? Collections.emptyList() : Arrays.asList(categoryViewModelResponse);
    }

    @Override
    public CategoryViewModel getCategoryById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/categories/" + id, CategoryViewModel.class);
    }

    @Override
    public CategoryViewModel saveCategory(CategoryViewModel categoryViewModel) {
        return null;
    }

    @Override
    public void deleteCategory(Integer Id) {

    }
}
