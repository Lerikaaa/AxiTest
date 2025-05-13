package org.example.myapp.dto;

public class ApplicationDto {
    private String fio;
    private String passport;
    private String gender;
    private String maritalStatus;
    private String residence;
    private String registration;
    private String phone;
    private String workPeriod;
    private String position;
    private String organization;
    private Integer loanAmount;
    private String additionalInfo;


    public ApplicationDto(String fio, String passport, String gender, String maritalStatus, String residence, String registration, String phone, String workPeriod, String position, String organization, Integer loanAmount, String additionalInfo) {
        this.fio = fio;
        this.passport = passport;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.residence = residence;
        this.registration = registration;
        this.phone = phone;
        this.workPeriod = workPeriod;
        this.position = position;
        this.organization = organization;
        this.loanAmount = loanAmount;
        this.additionalInfo = additionalInfo;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(String workPeriod) {
        this.workPeriod = workPeriod;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
