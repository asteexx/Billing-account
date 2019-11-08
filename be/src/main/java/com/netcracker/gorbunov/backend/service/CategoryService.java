package com.netcracker.gorbunov.backend.service;

import com.netcracker.gorbunov.backend.entity.CategoryEntity;

import java.util.Optional;

public interface CategoryService {
    CategoryEntity saveCategory(CategoryEntity categoryEntity);
    Optional<CategoryEntity> getCategoryEntityById(Integer id);
    Iterable<CategoryEntity> getAllCategories();
    void deleteCategory(Integer id);
}
