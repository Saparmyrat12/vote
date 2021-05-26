package com.epam.vote.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Restaurant domain.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 19, 2021
 * @author Sapar
 */
public class Restaurant extends AbstractDomain {

    private String name;
    private String address;
    private String createdUser;
    private String updatedUser;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private int recordVersion;

    public Restaurant() {
    }

    public Restaurant(String name, String address, String createdUser, String updatedUser,
                      LocalDate createdDate, LocalDate updatedDate, int recordVersion) {
        this.name = name;
        this.address = address;
        this.createdUser = createdUser;
        this.updatedUser = updatedUser;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.recordVersion = recordVersion;
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
        return recordVersion == that.recordVersion && name.equals(that.name) && address
                .equals(that.address) && createdUser.equals(that.createdUser) && updatedUser
                .equals(that.updatedUser) && createdDate
                .equals(that.createdDate) && updatedDate.equals(that.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, address, createdUser, updatedUser,
                createdDate, updatedDate, recordVersion);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", createdUser='" + createdUser + '\'' +
                ", updatedUser='" + updatedUser + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", recordVersion=" + recordVersion +
                '}';
    }
}
