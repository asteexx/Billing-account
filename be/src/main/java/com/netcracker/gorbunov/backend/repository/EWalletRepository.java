package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.EWalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EWalletRepository extends JpaRepository<EWalletEntity, Integer> {
}
