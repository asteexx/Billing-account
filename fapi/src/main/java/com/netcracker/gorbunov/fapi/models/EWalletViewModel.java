package com.netcracker.gorbunov.fapi.models;

import java.math.BigDecimal;

public class EWalletViewModel {
    private int id;
    private BigDecimal moneyAmmount;
    private Integer subscriberId;

    public EWalletViewModel() {
    }

    public EWalletViewModel(int id, BigDecimal moneyAmmount, Integer subscriberId) {
        this.id = id;
        this.moneyAmmount = moneyAmmount;
        this.subscriberId = subscriberId;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getMoneyAmmount() {
        return moneyAmmount;
    }

    public void setMoneyAmmount(BigDecimal moneyAmmount) {
        this.moneyAmmount = moneyAmmount;
    }

    public Integer getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Integer subscriberId) {
        this.subscriberId = subscriberId;
    }


}
