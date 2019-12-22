package com.netcracker.gorbunov.backend.entity;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "users", schema = "space_chanels")

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

    @NotBlank(message = "Login can not be null")
    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email can not be null")
    @Basic
    @Column(name = "e_mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @NotBlank(message = "Password can not be null")
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    @Basic
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
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
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "phone_number")
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "adress")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersEntity)) return false;
        UsersEntity that = (UsersEntity) o;
        return idUser == that.idUser &&
                login.equals(that.login) &&
                eMail.equals(that.eMail) &&
                password.equals(that.password) &&
                role == that.role &&
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

    @OneToMany()
    @JoinColumn(name = "subscriber_id")
    public Collection<EWalletEntity> geteWalletsByIdUser() {
        return eWalletsByIdUser;
    }

    public void seteWalletsByIdUser(Collection<EWalletEntity> eWalletsByIdUser) {
        this.eWalletsByIdUser = eWalletsByIdUser;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "subscribers_on_chanel",
            joinColumns = { @JoinColumn(name = "id_subscriber") },
            inverseJoinColumns = { @JoinColumn(name = "id_chanel") })
    private Set<ChanelsEntity> tags = new HashSet<>();





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
    }
}
