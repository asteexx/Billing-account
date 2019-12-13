package com.netcracker.gorbunov.backend.controller;

import com.netcracker.gorbunov.backend.entity.EWalletEntity;
import com.netcracker.gorbunov.backend.service.EWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/e-wallet")
public class EWalletController {
    private EWalletService eWalletService;

    @Autowired
    public EWalletController(EWalletService eWalletService) {
        this.eWalletService = eWalletService;
    }


    @PostMapping(("/add"))
    public EWalletEntity addMoney(@RequestBody EWalletEntity eWalletEntity) {
        return eWalletService.addMoney(eWalletEntity);
    }

    @GetMapping(value = "")
    public Iterable<EWalletEntity> getAllWallets() {
        return eWalletService.getAllWallets();
    }
}
