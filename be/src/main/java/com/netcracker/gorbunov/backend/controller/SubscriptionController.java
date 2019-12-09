package com.netcracker.gorbunov.backend.controller;

import com.netcracker.gorbunov.backend.entity.SubscribersOnChanelEntity;
import com.netcracker.gorbunov.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping(value = "")
    public Iterable<SubscribersOnChanelEntity> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();

    }

    @PostMapping(value = "")
    public SubscribersOnChanelEntity subscribe(@RequestBody SubscribersOnChanelEntity subscription) {
        return subscriptionService.subscribe(subscription);

    }

    @RequestMapping(value = "subscriber/{idSubscriber}/chanel/{idChanel}", method = RequestMethod.DELETE)
    public void unsubscribe(@PathVariable(name = "idChanel") Integer idChanel, @PathVariable(name = "idSubscriber")Integer idSubscriber) {
        subscriptionService.unsubscribe(idChanel, idSubscriber);
    }

}
