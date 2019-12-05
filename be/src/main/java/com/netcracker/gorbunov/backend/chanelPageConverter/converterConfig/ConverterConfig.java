package com.netcracker.gorbunov.backend.chanelPageConverter.converterConfig;

import com.netcracker.gorbunov.backend.chanelPageConverter.PageChanelsEntityToPageChanelModelConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ConverterConfig {
    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new PageChanelsEntityToPageChanelModelConverter());
        return service;
    }
}




