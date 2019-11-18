package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.beClasses.ChanelModel;
import com.netcracker.gorbunov.fapi.models.ChanelViewModel;

import java.util.List;

public interface ChanelDataService {
    List<ChanelModel> getAllChanels();
    ChanelModel getChanelById(Integer id);
    ChanelModel saveChanel(ChanelViewModel chanelViewModel);
    void deleteChanel(Integer id);
}
