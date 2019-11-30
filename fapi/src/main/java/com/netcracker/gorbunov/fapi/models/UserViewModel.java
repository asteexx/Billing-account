package com.netcracker.gorbunov.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.gorbunov.fapi.beClasses.EWalletModel;
import com.netcracker.gorbunov.fapi.beClasses.UserModel;

import java.util.Collection;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserViewModel {
    private int idUser;
    private String login;
    private String eMail;
    private String password;
    private String role;
    private Integer idCompany;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String adress;
    private Collection<EWalletModel> eWalletsByIdUser;

    public UserViewModel() {
    }

    public UserViewModel(int idUser, String login, String eMail, String password, String role, Integer idCompany, String firstName, String lastName, Integer phoneNumber, String adress, Collection<EWalletModel> eWalletsByIdUser) {
        this.idUser = idUser;
        this.login = login;
        this.eMail = eMail;
        this.password = password;
        this.role = role;
        this.idCompany = idCompany;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.eWalletsByIdUser = eWalletsByIdUser;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
        if (!(o instanceof UserViewModel)) return false;
        UserViewModel that = (UserViewModel) o;
        return idUser == that.idUser &&
                login.equals(that.login) &&
                eMail.equals(that.eMail) &&
                password.equals(that.password) &&
                role.equals(that.role) &&
                Objects.equals(idCompany, that.idCompany) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(adress, that.adress) &&
                Objects.equals(eWalletsByIdUser, that.eWalletsByIdUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, login, eMail, password, role, idCompany, firstName, lastName, phoneNumber, adress, eWalletsByIdUser);
    }

    @Override
    public String toString() {
        return "UserViewModel{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
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
