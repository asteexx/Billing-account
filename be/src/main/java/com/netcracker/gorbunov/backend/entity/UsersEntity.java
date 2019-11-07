package com.netcracker.gorbunov.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "space_chanels", catalog = "")
public class UsersEntity {
    private int idUser;
    private String login;
    private String eMail;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Integer idCompany;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String adress;
    private Collection<EWalletEntity> eWalletsByIdUser;

    @Id
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "e-mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Basic
    @Column(name = "id_company")
    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    @Basic
    @Column(name = "First Name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Last Name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Phone-number")
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "Adress")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return idUser == that.idUser &&
                Objects.equals(login, that.login) &&
                Objects.equals(eMail, that.eMail) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role) &&
                Objects.equals(idCompany, that.idCompany) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(adress, that.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, login, eMail, password, role, idCompany, firstName, lastName, phoneNumber, adress);
    }

    @OneToMany()
    @JoinColumn(name = "subscriber_id")
    public Collection<EWalletEntity> geteWalletsByIdUser() {
        return eWalletsByIdUser;
    }

    public void seteWalletsByIdUser(Collection<EWalletEntity> eWalletsByIdUser) {
        this.eWalletsByIdUser = eWalletsByIdUser;
    }

    public enum Role{
        COMPANY, CUSTOMER, ADMIN;
    }
}
