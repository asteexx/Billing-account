package com.netcracker.gorbunov.fapi.controller;

import com.netcracker.gorbunov.fapi.models.CategoryViewModel;
import com.netcracker.gorbunov.fapi.service.CategoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba")
public class CategoryDataController {

    @Autowired
    private CategoryDataService categoryDataService;

    @RequestMapping
    public ResponseEntity<List<CategoryViewModel>> getAllCategories() {
        return ResponseEntity.ok(categoryDataService.getAll());
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<CategoryViewModel> getAllCategories(@PathVariable String id) throws InterruptedException {
        Integer categoryId = Integer.valueOf(id);
        return ResponseEntity.ok(categoryDataService.getCategoryById(categoryId));
    }
}
