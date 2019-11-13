package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.CompaniesEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<CompaniesEntity, Integer> {
}
