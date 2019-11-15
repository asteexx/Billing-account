package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.CompaniesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompaniesEntity, Integer> {

}
