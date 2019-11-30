package com.netcracker.gorbunov.fapi.converter.chanel;

import com.netcracker.gorbunov.fapi.beClasses.ChanelModel;
import com.netcracker.gorbunov.fapi.models.ChanelViewModel;
import org.springframework.core.convert.converter.Converter;

public class ChanelModelToChanelViewModelConverter implements Converter<ChanelModel, ChanelViewModel> {

    @Override
    public ChanelViewModel convert(ChanelModel companiesByOwner) {
        ChanelViewModel chanelViewModel = new ChanelViewModel();
        chanelViewModel.setId(companiesByOwner.getId());
        chanelViewModel.setCompaniesByOwner(companiesByOwner.getCompaniesByOwner().getName());
        chanelViewModel.setChanelName(companiesByOwner.getChanelName());
        chanelViewModel.setPrice(companiesByOwner.getPrice());
        chanelViewModel.setSmallDiscription(companiesByOwner.getSmallDiscription());
        return chanelViewModel;
    }
}

