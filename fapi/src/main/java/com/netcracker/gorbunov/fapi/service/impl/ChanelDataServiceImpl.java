package com.netcracker.gorbunov.fapi.service.impl;


import com.netcracker.gorbunov.fapi.models.ChanelViewModel;
import com.netcracker.gorbunov.fapi.service.ChanelDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class ChanelDataServiceImpl implements ChanelDataService {


    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public List<ChanelViewModel> getAllChanels() {
        RestTemplate restTemplate = new RestTemplate();
        ChanelViewModel[] chanelViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/chanels/", ChanelViewModel[].class);
        return chanelViewModelResponse == null ? Collections.emptyList() : Arrays.asList(chanelViewModelResponse);
    }

    @Override
    public ChanelViewModel getChanelById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/chanels/" + id, ChanelViewModel.class);
    }

    @Override
    public ChanelViewModel saveChanel(ChanelViewModel chanelViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/chanels", chanelViewModel, ChanelViewModel.class).getBody();

    }

    @Override
    public void deleteChanel(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/chanels/" + id);
    }
}
