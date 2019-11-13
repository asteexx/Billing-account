package com.netcracker.gorbunov.backend.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "companies", schema = "space_chanels")
public class CompaniesEntity {
    private int idCompany;
    private String name;
    private String shortDescription;
    private BigDecimal moneyOnBankAccount;

    @Id
    @Column(name = "id_company")
    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "short_description")
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Basic
    @Column(name = "money_on_bank_account")
    public BigDecimal getMoneyOnBankAccount() {
        return moneyOnBankAccount;
    }

    public void setMoneyOnBankAccount(BigDecimal moneyOnBankAccount) {
        this.moneyOnBankAccount = moneyOnBankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompaniesEntity that = (CompaniesEntity) o;
        return idCompany == that.idCompany &&
                Objects.equals(name, that.name) &&
                Objects.equals(shortDescription, that.shortDescription) &&
                Objects.equals(moneyOnBankAccount, that.moneyOnBankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompany, name, shortDescription, moneyOnBankAccount);
    }
}
