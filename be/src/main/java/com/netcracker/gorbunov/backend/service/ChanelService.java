package com.netcracker.gorbunov.backend.service;

import com.netcracker.gorbunov.backend.entity.ChanelsEntity;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ChanelService {

    ChanelsEntity saveChanel(ChanelsEntity chanelsEntity);
    Optional<ChanelsEntity> getChanelEntityById(Integer id);
    Iterable<ChanelsEntity> getAllChanels(int page);
    void deleteChanel(Integer id);
}
