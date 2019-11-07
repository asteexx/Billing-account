package com.netcracker.gorbunov.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "e_wallet", schema = "space_chanels", catalog = "")
public class EWalletEntity {
    private int id;
    private BigDecimal moneyAmmount;
    private Integer subscriberId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "money_ammount")
    public BigDecimal getMoneyAmmount() {
        return moneyAmmount;
    }

    public void setMoneyAmmount(BigDecimal moneyAmmount) {
        this.moneyAmmount = moneyAmmount;
    }

    @Basic
    @Column(name = "subscriber_id")
    public Integer getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Integer subscriberId) {
        this.subscriberId = subscriberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EWalletEntity that = (EWalletEntity) o;
        return id == that.id &&
                Objects.equals(moneyAmmount, that.moneyAmmount) &&
                Objects.equals(subscriberId, that.subscriberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moneyAmmount, subscriberId);
    }
}
