package com.netcracker.gorbunov.fapi.controller;


import com.netcracker.gorbunov.fapi.beClasses.ChanelModel;
import com.netcracker.gorbunov.fapi.beClasses.ChanelModelPage;
import com.netcracker.gorbunov.fapi.beClasses.PageModel;
import com.netcracker.gorbunov.fapi.models.ChanelViewModel;
import com.netcracker.gorbunov.fapi.service.ChanelDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<PageModel<ChanelViewModel>> getAllChanelsPage(@RequestParam int page) {

        ChanelModelPage chanelModelPage = chanelDataService.getAllChanels(page);
        List<ChanelViewModel> chanelViewModelList = chanelModelPage.getContent().stream()
                .map(chanelModel -> conversionService.convert(chanelModel, ChanelViewModel.class))
                .collect(Collectors.toList());
        PageModel<ChanelViewModel> chanelViewModelPageModel = new PageModel<>(chanelViewModelList, chanelModelPage.getTotalPages());
        return ResponseEntity.ok(chanelViewModelPageModel);

    }


    @PostMapping()
    public ResponseEntity<ChanelModel> saveChanel(@RequestBody ChanelViewModel chanelViewModel /*todo server validation*/) {
        if (chanelViewModel != null) {

            return ResponseEntity.ok(

                    chanelDataService.saveChanel(
                            conversionService.convert(chanelViewModel, ChanelModel.class)));

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
