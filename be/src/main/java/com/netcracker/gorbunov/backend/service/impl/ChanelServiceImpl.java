package com.netcracker.gorbunov.backend.service.impl;

import com.netcracker.gorbunov.backend.entity.ChanelsEntity;
import com.netcracker.gorbunov.backend.repository.ChanelRepository;
import com.netcracker.gorbunov.backend.service.ChanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ChanelServiceImpl implements ChanelService {

    private ChanelRepository repository;

    @Autowired
    public ChanelServiceImpl(ChanelRepository repository){
        this.repository = repository;
    }

    @Override
    public ChanelsEntity saveChanel(ChanelsEntity chanelsEntity) {
        return repository.save(chanelsEntity);
    }

    @Override
    public Optional<ChanelsEntity> getChanelEntityById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Page<ChanelsEntity> getAllChanels(int page) {
        return repository.findAll(PageRequest.of(page, 6, Sort.by("chanelName")));
    }


    @Override
    public void deleteChanel(Integer id) {
        repository.deleteById(id);

    }
}
