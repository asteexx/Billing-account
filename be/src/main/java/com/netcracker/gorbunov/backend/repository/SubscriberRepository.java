package com.netcracker.gorbunov.backend.repository;

import com.netcracker.gorbunov.backend.entity.SubscribersOnChanelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository  extends JpaRepository<SubscribersOnChanelEntity, Integer>{
    void deleteByIdChanelAndIdSubscriber(Integer idChanel, Integer idSubscriber);
}
