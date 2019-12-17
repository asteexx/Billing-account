package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.ChanelsEntity;
import com.netcracker.gorbunov.backend.entity.SubscribersOnChanelEntity;
import com.netcracker.gorbunov.backend.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriberRepository  extends JpaRepository<SubscribersOnChanelEntity, Integer> {
    void deleteByIdChanelAndIdSubscriber(Integer idChanel, Integer idSubscriber);
    void getChanelEntityByIdChanel(Integer idChanel);
    void getUserEntityByIdSubscriber(Integer idSubscriber);
}
