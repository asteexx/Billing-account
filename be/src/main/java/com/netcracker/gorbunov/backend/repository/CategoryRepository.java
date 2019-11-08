package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
}
