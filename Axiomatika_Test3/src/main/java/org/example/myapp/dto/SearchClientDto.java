package org.example.myapp.dto;

public class SearchClientDto {
    private String phone;
    private String fio;
    private String passport;

    public SearchClientDto(String phone, String fio, String passport) {
        this.phone = phone;
        this.fio = fio;
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
