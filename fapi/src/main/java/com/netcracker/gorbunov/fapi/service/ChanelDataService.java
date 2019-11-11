package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.models.ChanelViewModel;

import java.util.List;

public interface ChanelDataService {
    List<ChanelViewModel> getAllChanels();
    ChanelViewModel getChanelById(Integer id);
    ChanelViewModel saveChanel(ChanelViewModel chanelViewModel);
    void deleteChanel(Integer id);
}
