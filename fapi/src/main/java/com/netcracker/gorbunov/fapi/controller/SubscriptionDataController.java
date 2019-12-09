package com.netcracker.gorbunov.fapi.controller;

import com.netcracker.gorbunov.fapi.models.SubscriptionViewModel;
import com.netcracker.gorbunov.fapi.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionDataController {

    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @GetMapping
    public ResponseEntity<List<SubscriptionViewModel>> getAllUsers() {
        return ResponseEntity.ok(subscriptionDataService.getAllSubscriptions());
    }


    @PostMapping()
    public ResponseEntity<SubscriptionViewModel> subscribe(@RequestBody SubscriptionViewModel subscriptionViewModel /*todo server validation*/) {
        if (subscriptionViewModel != null) {
            return ResponseEntity.ok(subscriptionDataService.subscribe(subscriptionViewModel));
        }
        return null;
    }
}
