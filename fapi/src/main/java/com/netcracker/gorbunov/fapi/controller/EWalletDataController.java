package com.netcracker.gorbunov.fapi.controller;

import com.netcracker.gorbunov.fapi.models.EWalletViewModel;
import com.netcracker.gorbunov.fapi.service.EWalletDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/e-wallet")
public class EWalletDataController {

    @Autowired
    private EWalletDataService eWalletDataService;

    @GetMapping
    public ResponseEntity<List<EWalletViewModel>> getAllUsers() {
        return ResponseEntity.ok(eWalletDataService.getAllWallets());
    }

    @PostMapping("/add")
    public ResponseEntity<EWalletViewModel> subscribe(@RequestBody EWalletViewModel eWalletViewModel /*todo server validation*/) {
        if (eWalletViewModel != null) {
            return ResponseEntity.ok(eWalletDataService.saveWallet(eWalletViewModel));
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping(value = "/{subscriber_id}")
    public ResponseEntity<EWalletViewModel> getUsersEWallet(@PathVariable Integer subscriber_id) {
        Integer userID = Integer.valueOf(subscriber_id);
        return ResponseEntity.ok(eWalletDataService.getUsersEWallet(userID));
    }

}
