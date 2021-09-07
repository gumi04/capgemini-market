package com.capgemini.market.domain;

public class Client {
    private String idClient;
    private String name;
    private String lastName;
    private Long cellphone;
    private String address;
    private String email;

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
