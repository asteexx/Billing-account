package com.netcracker.gorbunov.backend.service;

import com.netcracker.gorbunov.backend.entity.EWalletEntity;

public interface EWalletService {
    EWalletEntity addMoney(EWalletEntity eWalletEntity);
    Iterable<EWalletEntity> getAllWallets();
}
