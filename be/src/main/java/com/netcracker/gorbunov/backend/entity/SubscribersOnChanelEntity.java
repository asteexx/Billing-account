package com.netcracker.gorbunov.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subscribers_on_chanel", schema = "space_chanels")
@IdClass(SubscribersOnChanelEntityPK.class)
public class SubscribersOnChanelEntity {
    private int idSubscriber;
    private int idChanel;

    @Id
    @Column(name = "id_subscriber")
    public int getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(int idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    @Id
    @Column(name = "id_chanel")
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
        SubscribersOnChanelEntity that = (SubscribersOnChanelEntity) o;
        return idSubscriber == that.idSubscriber &&
                idChanel == that.idChanel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubscriber, idChanel);
    }
}
