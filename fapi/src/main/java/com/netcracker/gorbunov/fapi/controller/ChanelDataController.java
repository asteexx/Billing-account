package com.netcracker.gorbunov.fapi.controller;


import com.netcracker.gorbunov.fapi.models.ChanelViewModel;
import com.netcracker.gorbunov.fapi.service.ChanelDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chanels")
public class ChanelDataController {

    @Autowired
    private ChanelDataService chanelDataService;



    @RequestMapping
    public ResponseEntity<List<ChanelViewModel>> getAllChanels() {
        return ResponseEntity.ok(chanelDataService.getAllChanels());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ChanelViewModel> saveChanel(@RequestBody ChanelViewModel chanelViewModel /*todo server validation*/) {
        if (chanelViewModel != null) {
            return ResponseEntity.ok(chanelDataService.saveChanel(chanelViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteChanel(@PathVariable Integer id) {
        chanelDataService.deleteChanel(Integer.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<ChanelViewModel> getChanelById(@PathVariable Integer id) throws InterruptedException {
        Integer chanelId = Integer.valueOf(id);
        return ResponseEntity.ok(chanelDataService.getChanelById(chanelId));
    }


}
