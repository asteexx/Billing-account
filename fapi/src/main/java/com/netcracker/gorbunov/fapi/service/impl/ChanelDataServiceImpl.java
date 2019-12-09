package com.netcracker.gorbunov.fapi.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.netcracker.gorbunov.fapi.beClasses.ChanelModel;
import com.netcracker.gorbunov.fapi.beClasses.ChanelModelPage;
import com.netcracker.gorbunov.fapi.beClasses.PageModel;
import com.netcracker.gorbunov.fapi.controller.UserDataController;
import com.netcracker.gorbunov.fapi.service.ChanelDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class ChanelDataServiceImpl implements ChanelDataService {


    @Value("${backend.server.url}")
    private String backendServerUrl;


//    @Override
//    public PageModel<ChanelModel> getAllChanels(int page) {
//        RestTemplate restTemplate = new RestTemplate();
//        PageModelWithChannelModel chanelViewModelResponse = restTemplate.getForObject
//                (backendServerUrl + "/api/chanels?page=" + page, PageModelWithChannelModel.class);
//        return chanelViewModelResponse == null ? new PageModel<ChanelModel>() : chanelViewModelResponse;
//    }


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
////    @JsonIgnoreProperties(ignoreUnknown = true)
//@JsonDeserialize(as = PageModelWithChannelModel.class)
//    class PageModelWithChannelModel extends PageModel<ChanelModel> {
//        public PageModelWithChannelModel() {
//        }
//
//        public PageModelWithChannelModel(List<ChanelModel> content, int totalPages) {
//            super(content, totalPages);
//        }
//    }
}
