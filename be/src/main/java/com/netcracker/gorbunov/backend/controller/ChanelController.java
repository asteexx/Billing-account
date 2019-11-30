package com.netcracker.gorbunov.backend.controller;


import com.netcracker.gorbunov.backend.entity.ChanelsEntity;
import com.netcracker.gorbunov.backend.service.ChanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/chanels")
public class ChanelController {

    private ChanelService chanelService;

    @Autowired
    private ChanelController(ChanelService chanelService){
        this.chanelService = chanelService;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ChanelsEntity> getChanelEntityById(@PathVariable(name = "id") Integer id) {
        Optional<ChanelsEntity> chanelsEntity = chanelService.getChanelEntityById(id);
        if (chanelsEntity.isPresent()) {
            return ResponseEntity.ok(chanelsEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ChanelsEntity> getAllChanels() {
        return chanelService.getAllChanels();
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
