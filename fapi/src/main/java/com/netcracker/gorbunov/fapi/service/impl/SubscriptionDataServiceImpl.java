package com.netcracker.gorbunov.fapi.service.impl;

import com.netcracker.gorbunov.fapi.models.SubscriptionViewModel;
import com.netcracker.gorbunov.fapi.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionDataServiceImpl implements SubscriptionDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<SubscriptionViewModel> getAllSubscriptions() {
        RestTemplate restTemplate = new RestTemplate();
        SubscriptionViewModel[] subscriptionViewModels = restTemplate.getForObject(backendServerUrl + "/api/subscriptions", SubscriptionViewModel[].class);
        return subscriptionViewModels == null ? Collections.emptyList() : Arrays.asList(subscriptionViewModels);

    }

    @Override
    public SubscriptionViewModel subscribe(SubscriptionViewModel subscription) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subscriptions", subscription, SubscriptionViewModel.class).getBody();

    }
}
