package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.models.SubscriptionViewModel;

import java.util.List;

public interface SubscriptionDataService {
    List<SubscriptionViewModel> getAllSubscriptions();
    SubscriptionViewModel subscribe(SubscriptionViewModel subscription);
    void unsubscribe(Integer idChanel, Integer idSubscriber);
}
