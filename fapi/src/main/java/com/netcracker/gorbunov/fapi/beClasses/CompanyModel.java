package com.netcracker.gorbunov.fapi.beClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyModel {

    private int idCompany;
    private String name;
    private String shortDescription;
    private BigDecimal moneyOnBankAccount;


    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public BigDecimal getMoneyOnBankAccount() {
        return moneyOnBankAccount;
    }

    public void setMoneyOnBankAccount(BigDecimal moneyOnBankAccount) {
        this.moneyOnBankAccount = moneyOnBankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyModel)) return false;
        CompanyModel that = (CompanyModel) o;
        return idCompany == that.idCompany &&
                name.equals(that.name) &&
                Objects.equals(shortDescription, that.shortDescription) &&
                moneyOnBankAccount.equals(that.moneyOnBankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompany, name, shortDescription, moneyOnBankAccount);
    }

    @Override
    public String toString() {
        return "CompanyModel{" +
                "idCompany=" + idCompany +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", moneyOnBankAccount=" + moneyOnBankAccount +
                '}';
    }
}
