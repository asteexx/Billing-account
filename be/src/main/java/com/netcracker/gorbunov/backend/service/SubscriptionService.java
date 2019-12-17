package com.netcracker.gorbunov.backend.service;

import com.netcracker.gorbunov.backend.entity.SubscribersOnChanelEntity;

import java.util.Optional;

public interface SubscriptionService {
    SubscribersOnChanelEntity subscribe(SubscribersOnChanelEntity subscribers);

    Optional<SubscribersOnChanelEntity> getSubscriptionById(Integer idChanel);

    Iterable<SubscribersOnChanelEntity> getAllSubscriptions();

    void unsubscribe(Integer idChanel, Integer idSubscriber);

    void getChanelOwnerByIdChanel(Integer idChanel);

    void getUserEntityByIdSubscriber(Integer idSubscriber);
}
