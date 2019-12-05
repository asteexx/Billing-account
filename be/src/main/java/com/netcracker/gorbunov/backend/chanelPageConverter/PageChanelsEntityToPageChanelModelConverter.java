package com.netcracker.gorbunov.backend.chanelPageConverter;

import com.netcracker.gorbunov.backend.entity.ChanelsEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

public class PageChanelsEntityToPageChanelModelConverter implements Converter<Page<ChanelsEntity>, ChanelEntityPage> {
    @Override
    public ChanelEntityPage convert(Page<ChanelsEntity> source) {
        ChanelEntityPage chanelEntityPage = new ChanelEntityPage();
        chanelEntityPage.setContent(source.getContent());
        chanelEntityPage.setTotalPages(source.getTotalPages());
        return chanelEntityPage;
    }
}
