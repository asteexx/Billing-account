package com.netcracker.gorbunov.fapi.converter.chanel;

import com.netcracker.gorbunov.fapi.beClasses.ChanelModel;
import com.netcracker.gorbunov.fapi.beClasses.CompanyModel;
import com.netcracker.gorbunov.fapi.models.ChanelViewModel;
import org.springframework.core.convert.converter.Converter;

public class ChanelViewModelToChanelModelConverter implements Converter<ChanelViewModel, ChanelModel> {


    @Override
    public ChanelModel convert(ChanelViewModel chanelViewModel) {
        ChanelModel chanelModel = new ChanelModel();
        CompanyModel companyModel = new CompanyModel();

        companyModel.setName(chanelViewModel.getCompaniesByOwner());

        chanelModel.setId(chanelViewModel.getId());
        chanelModel.setChanelName(chanelViewModel.getChanelName());
        chanelModel.setPrice(chanelViewModel.getPrice());
        chanelModel.setSmallDiscription(chanelViewModel.getSmallDiscription());
        chanelModel.setOwner(chanelViewModel.getOwner());
        System.out.println(chanelModel);
        return chanelModel;

    }
}