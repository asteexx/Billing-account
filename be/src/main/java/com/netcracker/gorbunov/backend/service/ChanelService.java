package com.netcracker.gorbunov.backend.service;

import com.netcracker.gorbunov.backend.chanelPageConverter.ChanelEntityPage;
import com.netcracker.gorbunov.backend.entity.ChanelsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface ChanelService {

    ChanelsEntity saveChanel(ChanelsEntity chanelsEntity);
    Optional<ChanelsEntity> getChanelEntityById(Integer id);
    Page<ChanelsEntity> findAll(int page);
    void deleteChanel(Integer id);
}
