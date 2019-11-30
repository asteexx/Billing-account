package com.netcracker.gorbunov.fapi.beClasses;

import java.util.Collection;
import java.util.Objects;


public class UserModel {

    private int idUser;
    private String login;
    private String eMail;
    private String password;
    private Role role;
    private Integer idCompany;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String adress;
    private Collection<EWalletModel> eWalletsByIdUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Collection<EWalletModel> geteWalletsByIdUser() {
        return eWalletsByIdUser;
    }

    public void seteWalletsByIdUser(Collection<EWalletModel> eWalletsByIdUser) {
        this.eWalletsByIdUser = eWalletsByIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel)) return false;
        UserModel userModel = (UserModel) o;
        return idUser == userModel.idUser &&
                login.equals(userModel.login) &&
                eMail.equals(userModel.eMail) &&
                password.equals(userModel.password) &&
                role == userModel.role &&
                Objects.equals(idCompany, userModel.idCompany) &&
                Objects.equals(firstName, userModel.firstName) &&
                Objects.equals(lastName, userModel.lastName) &&
                Objects.equals(phoneNumber, userModel.phoneNumber) &&
                Objects.equals(adress, userModel.adress) &&
                Objects.equals(eWalletsByIdUser, userModel.eWalletsByIdUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, login, eMail, password, role, idCompany, firstName, lastName, phoneNumber, adress, eWalletsByIdUser);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", idCompany=" + idCompany +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", adress='" + adress + '\'' +
                ", eWalletsByIdUser=" + eWalletsByIdUser +
                '}';
    }

    public enum Role {
        COMPANY("COMPANY"),
        ADMIN("ADMIN"),
        CUSTOMER("CUSTOMER");

        private String value;

        private Role(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
