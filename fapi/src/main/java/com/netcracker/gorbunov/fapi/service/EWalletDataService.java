package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.models.EWalletViewModel;

import java.util.List;

public interface EWalletDataService {
    List<EWalletViewModel> getAllWallets();
    EWalletViewModel saveWallet(EWalletViewModel eWalletViewModel);
}
