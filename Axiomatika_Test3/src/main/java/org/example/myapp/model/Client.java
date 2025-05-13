package org.example.myapp.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId; // Уникальный идентификатор клиента

    @Column(name = "full_name", nullable = false)
    private String fullName; // Полное имя клиента

    @Column(name = "passport", nullable = false)
    private String passport; // Номер паспорта клиента

    @Column(name = "gender")
    private String gender; // Пол клиента

    @Column(name = "marital_status")
    private String maritalStatus; // Семейное положение клиента

    @Column(name = "residence_address")
    private String residenceAddress; // Адрес проживания клиента

    @Column(name = "registration_address")
    private String registrationAddress; // Адрес регистрации клиента

    @Column(name = "phone", unique = true, nullable = false)
    private String phone; // Телефон клиента

    // Геттеры и сеттеры
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
