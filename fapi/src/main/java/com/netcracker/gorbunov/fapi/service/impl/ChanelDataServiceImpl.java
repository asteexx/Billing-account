package com.netcracker.gorbunov.fapi.service.impl;


import com.netcracker.gorbunov.fapi.beClasses.ChanelModel;
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
    public List<ChanelModel> getAllChanels() {
        RestTemplate restTemplate = new RestTemplate();
        ChanelModel[] chanelViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/chanels", ChanelModel[].class);
        return chanelViewModelResponse == null ? Collections.emptyList() : Arrays.asList(chanelViewModelResponse);
    }

    @Override
    public ChanelModel getChanelById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/chanels/" + id, ChanelModel.class);
    }

    @Override
    public ChanelModel saveChanel(ChanelModel chanelModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/chanels", chanelModel, ChanelModel.class).getBody();

    }

    @Override
    public void deleteChanel(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/chanels/" + id);
    }
}
