package com.netcracker.gorbunov.fapi.service.impl;

import com.netcracker.gorbunov.fapi.beClasses.ChanelModel;
import com.netcracker.gorbunov.fapi.beClasses.ChanelModelPage;
import com.netcracker.gorbunov.fapi.controller.UserDataController;
import com.netcracker.gorbunov.fapi.service.ChanelDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ChanelDataServiceImpl implements ChanelDataService {


    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public ChanelModelPage getAllChanels(int page) {
        RestTemplate restTemplate = new RestTemplate();
        ChanelModelPage chanelViewModelResponse = restTemplate.getForObject
                (backendServerUrl + "/api/chanels?page=" + page, ChanelModelPage.class);
        return chanelViewModelResponse == null ? new ChanelModelPage() : chanelViewModelResponse;
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
        UserDataController userDataController = new UserDataController();
        //userDataController.getCurrentUser();
        restTemplate.delete(backendServerUrl + "/api/chanels/" + id);
    }
}
