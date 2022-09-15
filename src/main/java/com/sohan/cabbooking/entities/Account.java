package com.sohan.cabbooking.entities;

import com.sohan.cabbooking.enums.AccountStatus;

public abstract class Account {
    String name;
    String phone;
    String dob;
    String address;
    AccountStatus status;

    public Account(String name) {
        this.name = name;
        this.status = AccountStatus.ACTIVE;
    }

    public Account(String name, String phone) {
        this.name = name;
        this.status = AccountStatus.ACTIVE;
        this.phone = phone;
    }

    public Account(String name, String phone, String dob) {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.status = AccountStatus.ACTIVE;
    }

    public Account(String name, String phone, String dob, String address) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.status = AccountStatus.ACTIVE;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public String getPhone() {
        return phone;
    }

}