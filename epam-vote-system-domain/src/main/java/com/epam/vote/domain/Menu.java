package com.epam.vote.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Menu domain.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 09, 2021
 * @author Sapar
 */
public class Menu extends BaseEntity<String> {

    private String name;
    private float price;

    public Menu() {
    }

    public Menu(String id, String name, float price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public Menu(String id, String name, float price, String createdUser, String updatedUser,
                LocalDate createdDate, LocalDate updatedDate, int recordVersion) {
        super(id, createdUser, updatedUser, createdDate, updatedDate, recordVersion);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Menu)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Menu menu = (Menu) o;
        return Float.compare(menu.price, price) == 0 && name.equals(menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
