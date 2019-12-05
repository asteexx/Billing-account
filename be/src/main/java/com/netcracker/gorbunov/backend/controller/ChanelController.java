package com.netcracker.gorbunov.backend.controller;


import com.netcracker.gorbunov.backend.chanelPageConverter.ChanelEntityPage;
import com.netcracker.gorbunov.backend.entity.ChanelsEntity;
import com.netcracker.gorbunov.backend.service.ChanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chanels")
public class ChanelController {

    private ChanelService chanelService;

    @Autowired
    private ChanelController(ChanelService chanelService) {
        this.chanelService = chanelService;
    }

    @Autowired
    private ConversionService conversionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ChanelsEntity> getChanelEntityById(@PathVariable(name = "id") Integer id) {
        Optional<ChanelsEntity> chanelsEntity = chanelService.getChanelEntityById(id);
        if (chanelsEntity.isPresent()) {
            return ResponseEntity.ok(chanelsEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //    @RequestMapping(value = "", method = RequestMethod.GET)
//    public List<ChanelsEntity> getAllChanels(@RequestParam int page){
//        List<ChanelsEntity> chanelsEntityList = (List<ChanelsEntity>) chanelService.findAll(page);
//        //do other implementations here
//        return chanelsEntityList;
//    }
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public Page<ChanelsEntity> getAllChanelsPage(@RequestParam int page) {
//        Page<ChanelsEntity> chanelsEntityList = chanelService.findAll(page);
//        //do other implementations here
//        return chanelsEntityList;
//    }



    @RequestMapping(value = "", method = RequestMethod.GET)
    public ChanelEntityPage<ChanelsEntity> getAllChanels(@RequestParam int page) {
        Page<ChanelsEntity> chanelsEntityList = chanelService.findAll(page);
       ChanelEntityPage<ChanelsEntity> chanelsEntityChanelEntityPage =   conversionService.convert(chanelsEntityList,ChanelEntityPage.class);
         return chanelsEntityChanelEntityPage;
    }



    @RequestMapping(method = RequestMethod.POST)
    public ChanelsEntity saveChanel(@RequestBody ChanelsEntity chanelsEntity) {
        System.out.println(chanelsEntity);
        return chanelService.saveChanel(chanelsEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteChanel(@PathVariable(name = "id") Integer id) {
        chanelService.deleteChanel(id);
    }

}
