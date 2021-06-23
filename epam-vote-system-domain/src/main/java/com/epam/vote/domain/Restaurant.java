package com.epam.vote.domain;

import java.util.Objects;

/**
 * Restaurant domain.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 19, 2021
 * @author Sapar
 */
public class Restaurant extends BaseEntity<String> {

    private String name;
    private String address;

    public Restaurant() {
    }

    public Restaurant(String id, String name, String address) {
        super(id);
        this.name = name;
        this.address = address;
    }

    public Restaurant(String id, String name, String address, String createdUser) {
        super(id, createdUser);
        this.name = name;
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Restaurant that = (Restaurant) o;
        return name.equals(that.name) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, address);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            '}';
    }
}
