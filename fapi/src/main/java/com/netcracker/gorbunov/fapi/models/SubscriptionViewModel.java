package com.netcracker.gorbunov.fapi.models;

public class SubscriptionViewModel {
    private int idSubscriber;
    private int idChanel;

    public SubscriptionViewModel(int idSubscriber, int idChanel) {
        this.idSubscriber = idSubscriber;
        this.idChanel = idChanel;
    }

    public int getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(int idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public int getIdChanel() {
        return idChanel;
    }

    public void setIdChanel(int idChanel) {
        this.idChanel = idChanel;
    }

    @Override
    public String toString() {
        return "SubscriptionViewModel{" +
                "idSubscriber=" + idSubscriber +
                ", idChanel=" + idChanel +
                '}';
    }
}
