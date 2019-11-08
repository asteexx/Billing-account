package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.models.CategoryViewModel;

import java.util.List;

public interface CategoryDataService {
    List<CategoryViewModel> getAll();
    CategoryViewModel getCategoryById(Integer id);
    CategoryViewModel saveCategory(CategoryViewModel categoryViewModel);
    void deleteCategory(Integer id);
}
