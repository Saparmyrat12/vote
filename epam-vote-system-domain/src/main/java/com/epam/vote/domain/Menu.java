package com.epam.vote.domain;

import java.math.BigDecimal;
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
    private BigDecimal price;

    public Menu() {
    }

    public Menu(String id, String name, BigDecimal price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
        return name.equals(menu.name) && price.equals(menu.price);
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
