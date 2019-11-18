package com.netcracker.gorbunov.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyViewModel {

    private int idCompany;
    private  String name;
    private String shortDescription;
    private BigDecimal moneyOnBankAccount;

    public CompanyViewModel(){}

    public CompanyViewModel(int idCompany, String name, String shortDescription, BigDecimal moneyOnBankAccount) {
        this.idCompany = idCompany;
        this.name = name;
        this.shortDescription = shortDescription;
        this.moneyOnBankAccount = moneyOnBankAccount;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public  String getName() {
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
}
