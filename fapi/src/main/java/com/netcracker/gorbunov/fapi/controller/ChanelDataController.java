package com.netcracker.gorbunov.fapi.controller;


import com.netcracker.gorbunov.fapi.beClasses.ChanelModel;
import com.netcracker.gorbunov.fapi.models.ChanelViewModel;
import com.netcracker.gorbunov.fapi.service.ChanelDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chanels")
public class ChanelDataController {

    @Autowired
    private ChanelDataService chanelDataService;

    @Autowired
    private ConversionService conversionService;

    @GetMapping
    public ResponseEntity<List<ChanelViewModel>> getAllChanels() {
        return ResponseEntity.ok(chanelDataService.getAllChanels()
                .stream()
                .map(chanel -> conversionService.convert(chanel, ChanelViewModel.class))
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<ChanelModel> saveChanel(@RequestBody ChanelViewModel chanelViewModel /*todo server validation*/) {
        if (chanelViewModel != null) {
            ;
            return ResponseEntity.ok(
                    conversionService.convert(
                            chanelDataService.saveChanel(
                                    conversionService.convert(chanelViewModel, ChanelModel.class)), ChanelModel.class));
        }
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteChanel(@PathVariable Integer id) {
        chanelDataService.deleteChanel(Integer.valueOf(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ChanelViewModel> getChanelById(@PathVariable Integer id) {
        Integer chanelId = Integer.valueOf(id);
        return ResponseEntity.ok(conversionService.convert(chanelDataService.getChanelById(chanelId), ChanelViewModel.class));
    }


}
