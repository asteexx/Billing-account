package com.netcracker.gorbunov.fapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChanelViewModel {
    private int id;
    private String chanelName;
    private int owner;
    private BigDecimal price;
    private String smallDiscription;
    private Integer category;



    public ChanelViewModel() {
    }

    public ChanelViewModel(int id, String chanelName, int owner, BigDecimal price, String smallDiscription, Integer category) {
        this.id = id;
        this.chanelName = chanelName;
        this.owner = owner;
        this.price = price;
        this.smallDiscription = smallDiscription;
        this.category = category;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChanelName() {
        return chanelName;
    }

    public void setChanelName(String chanelName) {
        this.chanelName = chanelName;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSmallDiscription() {
        return smallDiscription;
    }

    public void setSmallDiscription(String smallDiscription) {
        this.smallDiscription = smallDiscription;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }



}
