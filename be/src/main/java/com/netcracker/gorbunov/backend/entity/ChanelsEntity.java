package com.netcracker.gorbunov.backend.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "chanels", schema = "space_chanels")
public class ChanelsEntity {
    private int id;
    private String chanelName;
    private int owner;
    private BigDecimal price;
    private String smallDiscription;
    private Integer category;
    private CompaniesEntity companiesByOwner;

    public ChanelsEntity() {
    }

    public ChanelsEntity(int id, String chanelName, int owner, BigDecimal price, String smallDiscription, Integer category, CompaniesEntity companiesByOwner) {
        this.id = id;
        this.chanelName = chanelName;
        this.owner = owner;
        this.price = price;
        this.smallDiscription = smallDiscription;
        this.category = category;
        this.companiesByOwner = companiesByOwner;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "chanel_name")
    public String getChanelName() {
        return chanelName;
    }

    public void setChanelName(String chanelName) {
        this.chanelName = chanelName;
    }

    @Basic
    @Column(name = "owner")
    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "small_discription")
    public String getSmallDiscription() {
        return smallDiscription;
    }

    public void setSmallDiscription(String smallDiscription) {
        this.smallDiscription = smallDiscription;
    }

    @Basic
    @Column(name = "category")
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChanelsEntity that = (ChanelsEntity) o;
        return id == that.id &&
                owner == that.owner &&
                Objects.equals(chanelName, that.chanelName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(smallDiscription, that.smallDiscription) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chanelName, owner, price, smallDiscription, category);
    }

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id_company", nullable = false, insertable = false, updatable = false)

    public CompaniesEntity getCompaniesByOwner() {
        return companiesByOwner;
    }

    public void setCompaniesByOwner(CompaniesEntity companiesByOwner) {
        this.companiesByOwner = companiesByOwner;
    }

    @Override
    public String toString() {
        return "ChanelsEntity{" +
                "id=" + id +
                ", chanelName='" + chanelName + '\'' +
                ", owner=" + owner +
                ", price=" + price +
                ", smallDiscription='" + smallDiscription + '\'' +
                ", category=" + category +
                ", companiesByOwner=" + companiesByOwner +
                '}';
    }

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "subscribers_on_chanel",
//            joinColumns = @JoinColumn(name = "id_chanel", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id_subscriber", referencedColumnName = "id_user"))
//    private Set<UsersEntity> subscribers;
//
//
//
//    public ChanelsEntity(int id, String chanelName, int owner, BigDecimal price, String smallDiscription, Integer category, CompaniesEntity companiesByOwner, UsersEntity... subscribers) {
//        this.id = id;
//        this.chanelName = chanelName;
//        this.owner = owner;
//        this.price = price;
//        this.smallDiscription = smallDiscription;
//        this.category = category;
//        this.companiesByOwner = companiesByOwner;
//        this.subscribers = Stream.of(subscribers).collect(Collectors.toSet());
//        this.subscribers.forEach(x -> x.get().add(this));
//    }
}
