package com.netcracker.gorbunov.fapi.beClasses;

import java.math.BigDecimal;
import java.util.Objects;

public class EWalletModel {
    private int id;
    private BigDecimal moneyAmmount;
    private Integer subscriberId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EWalletModel)) return false;
        EWalletModel that = (EWalletModel) o;
        return id == that.id &&
                moneyAmmount.equals(that.moneyAmmount) &&
                Objects.equals(subscriberId, that.subscriberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moneyAmmount, subscriberId);
    }

    @Override
    public String toString() {
        return "EWalletModel{" +
                "id=" + id +
                ", moneyAmmount=" + moneyAmmount +
                ", subscriberId=" + subscriberId +
                '}';
    }
}
