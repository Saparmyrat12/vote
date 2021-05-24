/**
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
    private String created_user;
    private String updated_user;
    private LocalDate created_date;
    private LocalDate updated_date;
    private int record_version;

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

    public String getCreated_user() {
        return created_user;
    }

    public void setCreated_user(String created_user) {
        this.created_user = created_user;
    }

    public String getUpdated_user() {
        return updated_user;
    }

    public void setUpdated_user(String updated_user) {
        this.updated_user = updated_user;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public LocalDate getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDate updated_date) {
        this.updated_date = updated_date;
    }

    public int getRecord_version() {
        return record_version;
    }

    public void setRecord_version(int record_version) {
        this.record_version = record_version;
    }

    public Restaurant(String id, String name, String address, String created_user, String updated_user,
                      LocalDate created_date, LocalDate updated_date, int record_version) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.created_user = created_user;
        this.updated_user = updated_user;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.record_version = record_version;
    }

    public Restaurant() {
    }
}
