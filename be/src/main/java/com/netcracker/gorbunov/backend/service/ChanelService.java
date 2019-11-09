package com.netcracker.gorbunov.backend.service;


import com.netcracker.gorbunov.backend.entity.CategoryEntity;
import com.netcracker.gorbunov.backend.entity.ChanelsEntity;

import java.util.Optional;

public interface ChanelService {

    ChanelsEntity saveChanel(ChanelsEntity chanelsEntity);
    Optional<ChanelsEntity> getChanelEntityById(Integer id);
    Iterable<ChanelsEntity> getAllChanels();
    void deleteChanel(Integer id);
}
