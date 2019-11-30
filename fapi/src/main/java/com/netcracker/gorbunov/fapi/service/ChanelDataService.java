package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.beClasses.ChanelModel;

import java.util.List;

public interface ChanelDataService {
    List<ChanelModel> getAllChanels();

    ChanelModel getChanelById(Integer id);

    ChanelModel saveChanel(ChanelModel chanelModel);

    void deleteChanel(Integer id);
}
