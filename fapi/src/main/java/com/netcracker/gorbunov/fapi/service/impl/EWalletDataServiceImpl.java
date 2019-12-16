package com.netcracker.gorbunov.fapi.service.impl;

import com.netcracker.gorbunov.fapi.models.EWalletViewModel;
import com.netcracker.gorbunov.fapi.service.EWalletDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EWalletDataServiceImpl implements EWalletDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<EWalletViewModel> getAllWallets() {
        RestTemplate restTemplate = new RestTemplate();
        EWalletViewModel[] eWalletViewModels = restTemplate.getForObject(backendServerUrl + "/api/e-wallet/", EWalletViewModel[].class);
        return eWalletViewModels == null ? Collections.emptyList() : Arrays.asList(eWalletViewModels);
    }

    @Override
    public EWalletViewModel saveWallet(EWalletViewModel eWalletViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/e-wallet/add", eWalletViewModel, EWalletViewModel.class).getBody();

    }

    @Override
    public EWalletViewModel getUsersEWallet(Integer subscriberID) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/e-wallet/" + subscriberID, EWalletViewModel.class);

    }
}
