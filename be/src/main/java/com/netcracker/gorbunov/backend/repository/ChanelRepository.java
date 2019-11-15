package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.ChanelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChanelRepository extends JpaRepository<ChanelsEntity, Integer> {
}
