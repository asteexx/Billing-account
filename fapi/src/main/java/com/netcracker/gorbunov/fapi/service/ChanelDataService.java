package com.netcracker.gorbunov.fapi.service;

import com.netcracker.gorbunov.fapi.beClasses.ChanelModel;
import com.netcracker.gorbunov.fapi.beClasses.ChanelModelPage;
import com.netcracker.gorbunov.fapi.beClasses.PageModel;

public interface ChanelDataService {
    ChanelModelPage getAllChanels(int page);

    ChanelModel getChanelById(Integer id);

    ChanelModel saveChanel(ChanelModel chanelModel);

    void deleteChanel(Integer id);
}
