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

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Configuration
@EnableScheduling
public class ChargingService {

    private UsersEntity userInAction;
    private ChanelsEntity chanelInAction;
    private CompaniesEntity companyInAction;
    private SubscribersOnChanelEntity subscription;
    static Calendar calendar = Calendar.getInstance();
    static int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    private static final BigDecimal period = BigDecimal.valueOf(days);
    private static final int scale = 2;

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

                EWalletEntity userWallet = eWalletRepository.findBySubscriberId(subscription.getIdSubscriber()).get();
                //got EWallet from User
                System.out.println("days in this month: " + period);
                userInAction = userService.getUserById(subscription.getIdSubscriber()).get();
                chanelInAction = chanelService.getChanelEntityById(subscription.getIdChanel()).get();
                companyInAction = companyService.getCompanyById(chanelInAction.getOwner()).get();
                BigDecimal price = chanelInAction.getPrice();
                BigDecimal pricePerDay = price.divide(period, scale, RoundingMode.CEILING);

                if (userWallet.getMoneyAmmount().compareTo(pricePerDay) >= 0) {
                    userWallet.setMoneyAmmount(userWallet.getMoneyAmmount().subtract(pricePerDay));
                    eWalletRepository.save(userWallet);
                    companyInAction.setMoneyOnBankAccount(companyInAction.getMoneyOnBankAccount().add(pricePerDay));
                    companyRepository.save(companyInAction);
                    System.out.println("sub active!  " + userInAction.getLogin() + " payed " + pricePerDay + " to " + companyInAction.getName() + " for " + chanelInAction.getChanelName());
                } else {
                    System.out.println("you are unsubscribed now!");
                    subscriptionService.unsubscribe(chanelInAction.getId(), userInAction.getIdUser());
                }
            }
        } else {
            System.out.println("no sub to transfer!");
        }
    }

     @Scheduled(cron = "0 35 3 ? * *") //	Fire at 3:35 AM every day

   // @Scheduled(fixedDelay = 10000) // charge every 10 sec
    public void doSmth() {

        this.moneyTransfer();
    }
}