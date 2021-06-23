package com.epam.vote.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Base entity.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 26, 2021
 * @param <T> id
 * @author Sapar
 */
public abstract class BaseEntity<T> {

    private T id;
    private String createdUser;
    private String updatedUser;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private int recordVersion;

    public BaseEntity() {
    }

    public BaseEntity(T id) {
        this.id = id;
    }

    public BaseEntity(T id, String createdUser, String updatedUser, LocalDate createdDate,
                      LocalDate updatedDate, int recordVersion) {
        this.id = id;
        this.createdUser = createdUser;
        this.updatedUser = updatedUser;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.recordVersion = recordVersion;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
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
        BaseEntity<?> that = (BaseEntity<?>) o;
        return recordVersion == that.recordVersion && id.equals(that.id) && createdUser
            .equals(that.createdUser) && updatedUser
            .equals(that.updatedUser) && createdDate
            .equals(that.createdDate) && updatedDate.equals(that.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdUser, updatedUser, createdDate, updatedDate, recordVersion);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
            "id=" + id +
            ", createdUser='" + createdUser + '\'' +
            ", updatedUser='" + updatedUser + '\'' +
            ", createdDate=" + createdDate +
            ", updatedDate=" + updatedDate +
            ", recordVersion=" + recordVersion +
            '}';
    }
}
