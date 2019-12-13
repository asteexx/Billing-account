package com.netcracker.gorbunov.backend.service.impl;

import com.netcracker.gorbunov.backend.entity.EWalletEntity;
import com.netcracker.gorbunov.backend.repository.EWalletRepository;
import com.netcracker.gorbunov.backend.service.EWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EWalletSrviceImpl implements EWalletService {

    private EWalletRepository eWalletRepository;

    @Autowired
    public EWalletSrviceImpl(EWalletRepository eWalletRepository) {
        this.eWalletRepository = eWalletRepository;
    }

    @Override
    public EWalletEntity addMoney(EWalletEntity eWalletEntity) {
        return eWalletRepository.save(eWalletEntity);
    }

    @Override
    public Iterable<EWalletEntity> getAllWallets() {
        return eWalletRepository.findAll();
    }
}
