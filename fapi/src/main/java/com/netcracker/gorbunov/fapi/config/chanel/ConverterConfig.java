package com.netcracker.gorbunov.fapi.config.chanel;

import com.netcracker.gorbunov.fapi.converter.chanel.ChanelModelToChanelViewModelConverter;
import com.netcracker.gorbunov.fapi.converter.user.UserModelToUserViewModelConverter;
import com.netcracker.gorbunov.fapi.converter.chanel.ChanelViewModelToChanelModelConverter;
import com.netcracker.gorbunov.fapi.converter.user.UserViewModelToUserModelConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ConverterConfig {
    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new ChanelModelToChanelViewModelConverter());
        service.addConverter(new ChanelViewModelToChanelModelConverter());
        service.addConverter(new UserModelToUserViewModelConverter());
        service.addConverter(new UserViewModelToUserModelConverter());
        return service;
    }
}




