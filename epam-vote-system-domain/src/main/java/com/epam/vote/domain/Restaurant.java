/**
 * This class describe table Restaurant.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 19, 2021
 * @author Sapar
 */
package com.epam.vote.domain;

import java.time.LocalDate;

public class Restaurant {

    private String id;
    private String name;
    private String address;
    private String createdUser;
    private String updatedUser;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private int recordVersion;

    public Restaurant() {
    }

    public Restaurant(String id, String name, String address, String createdUser, String updatedUser,
                      LocalDate createdDate, LocalDate updatedDate, int recordVersion) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.createdUser = createdUser;
        this.updatedUser = updatedUser;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.recordVersion = recordVersion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(int recordVersion) {
        this.recordVersion = recordVersion;
    }


}
