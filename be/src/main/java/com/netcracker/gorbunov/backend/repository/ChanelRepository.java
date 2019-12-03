package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.ChanelsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChanelRepository extends JpaRepository<ChanelsEntity, Integer> {

}
