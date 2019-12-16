package com.netcracker.gorbunov.backend.service;

import com.netcracker.gorbunov.backend.entity.EWalletEntity;

import java.util.Optional;

public interface EWalletService {
    EWalletEntity addMoney(EWalletEntity eWalletEntity);
    Iterable<EWalletEntity> getAllWallets();
    Optional<EWalletEntity> findBySubscriberId(Integer subscriberId);

}
