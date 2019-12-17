package com.netcracker.gorbunov.backend.charging;

import com.netcracker.gorbunov.backend.entity.*;
import com.netcracker.gorbunov.backend.repository.CompanyRepository;
import com.netcracker.gorbunov.backend.repository.EWalletRepository;
import com.netcracker.gorbunov.backend.repository.SubscriberRepository;
import com.netcracker.gorbunov.backend.service.ChanelService;
import com.netcracker.gorbunov.backend.service.CompanyService;
import com.netcracker.gorbunov.backend.service.SubscriptionService;
import com.netcracker.gorbunov.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Configuration
@EnableScheduling
public class ChargingService {


    private UsersEntity userInAction;
    private ChanelsEntity chanelInAction;
    private CompaniesEntity companyInAction;
    private SubscribersOnChanelEntity subscription;

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EWalletRepository eWalletRepository;
    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ChanelService chanelService;
    @Autowired
    private UserService userService;

    @Transactional
    public void moneyTransfer() {
        if (subscriptionService.getAllSubscriptions().iterator().hasNext()) {

            List<SubscribersOnChanelEntity> subbs =
                    StreamSupport.stream(subscriptionService.getAllSubscriptions().spliterator(), false)
                            .collect(Collectors.toList());
            for (SubscribersOnChanelEntity subscription : subbs) {
                // subscription = subbs.get(0);


                EWalletEntity userWallet = eWalletRepository.findBySubscriberId(subscription.getIdSubscriber()).get();
                //got EWallet from User
                System.out.println(userWallet);
                userInAction = userService.getUserById(subscription.getIdSubscriber()).get();
                chanelInAction = chanelService.getChanelEntityById(subscription.getIdChanel()).get();
                companyInAction = companyService.getCompanyById(chanelInAction.getOwner()).get();
                BigDecimal price = chanelInAction.getPrice();

                BigDecimal pricePerDay = price.divide(new BigDecimal(2));

                if (userWallet.getMoneyAmmount().compareTo(pricePerDay) >= 0) {
                    userWallet.setMoneyAmmount(userWallet.getMoneyAmmount().subtract(pricePerDay));
                    eWalletRepository.save(userWallet);
                    companyInAction.setMoneyOnBankAccount(companyInAction.getMoneyOnBankAccount().add(pricePerDay));
                    companyRepository.save(companyInAction);
                    System.out.println("sub active!");
                } else {
                    System.out.println("you are unsubscribed now!");
                    subscriptionService.unsubscribe(chanelInAction.getId(), userInAction.getIdUser());

                }
            }
        } else {
            System.out.println("no sub to transfer!");
        }

    }

    @Scheduled(fixedDelay = 10000)
    public void doSmth() {

        this.moneyTransfer();
    }
}
