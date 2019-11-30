package com.netcracker.gorbunov.fapi.beClasses;

import java.math.BigDecimal;
import java.util.Objects;


public class ChanelModel {
    private int id;
    private String chanelName;
    private int owner;
    private BigDecimal price;
    private String smallDiscription;
    private Integer category;
    private CompanyModel companiesByOwner;

    public ChanelModel() {
    }

    public ChanelModel(int id, String chanelName, int owner, BigDecimal price, String smallDiscription, Integer category, CompanyModel companiesByOwner) {
        this.id = id;
        this.chanelName = chanelName;
        this.owner = owner;
        this.price = price;
        this.smallDiscription = smallDiscription;
        this.category = category;
        this.companiesByOwner = companiesByOwner;
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

    public CompanyModel getCompaniesByOwner() {
        return companiesByOwner;
    }

    public void setCompaniesByOwner(CompanyModel companiesByOwner) {
        this.companiesByOwner = companiesByOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChanelModel)) return false;
        ChanelModel that = (ChanelModel) o;
        return id == that.id &&
                owner == that.owner &&
                chanelName.equals(that.chanelName) &&
                price.equals(that.price) &&
                smallDiscription.equals(that.smallDiscription) &&
                Objects.equals(category, that.category) &&
                companiesByOwner.equals(that.companiesByOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chanelName, owner, price, smallDiscription, category, companiesByOwner);
    }

    @Override
    public String toString() {
        return "ChanelModel{" +
                "id=" + id +
                ", chanelName='" + chanelName + '\'' +
                ", owner=" + owner +
                ", price=" + price +
                ", smallDiscription='" + smallDiscription + '\'' +
                ", category=" + category +
                ", companiesByOwner=" + companiesByOwner +
                '}';
    }
}
