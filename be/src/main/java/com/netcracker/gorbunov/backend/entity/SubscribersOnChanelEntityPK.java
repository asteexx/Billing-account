package com.netcracker.gorbunov.backend.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SubscribersOnChanelEntityPK implements Serializable {
    private int idSubscriber;
    private int idChanel;

    @Column(name = "id_subscriber")
    @Id
    public int getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(int idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    @Column(name = "id_chanel")
    @Id
    public int getIdChanel() {
        return idChanel;
    }

    public void setIdChanel(int idChanel) {
        this.idChanel = idChanel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscribersOnChanelEntityPK that = (SubscribersOnChanelEntityPK) o;
        return idSubscriber == that.idSubscriber &&
                idChanel == that.idChanel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubscriber, idChanel);
    }
}
