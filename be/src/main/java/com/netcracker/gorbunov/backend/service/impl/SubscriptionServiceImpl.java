package com.netcracker.gorbunov.backend.service.impl;

import com.netcracker.gorbunov.backend.entity.SubscribersOnChanelEntity;
import com.netcracker.gorbunov.backend.repository.SubscriberRepository;
import com.netcracker.gorbunov.backend.service.ChanelService;
import com.netcracker.gorbunov.backend.service.SubscriptionService;
import com.netcracker.gorbunov.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriberRepository subscriberRepository;
    private ChanelService chanelService;
    private UserService userService;

    @Autowired
    public SubscriptionServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public SubscribersOnChanelEntity subscribe(SubscribersOnChanelEntity subscribers) {
        return subscriberRepository.save(subscribers);
    }

    @Override
    public Optional<SubscribersOnChanelEntity> getSubscriptionById(Integer idChanel) {
        return subscriberRepository.findById(idChanel);
    }

    @Override
    public Iterable<SubscribersOnChanelEntity> getAllSubscriptions() {
        return subscriberRepository.findAll();
    }

    @Override
    @Transactional
    public void unsubscribe(Integer idChanel, Integer idSubscriber) {
        subscriberRepository.deleteByIdChanelAndIdSubscriber(idChanel, idSubscriber);
    }

    @Override
    public void getChanelOwnerByIdChanel(Integer idChanel) {

    }

    @Override
    public void getUserEntityByIdSubscriber(Integer idSubscriber) {

    }
}
