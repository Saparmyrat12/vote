/**
 * This class is used for dto Restaurant.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 20, 2021
 * @author Sapar
 */
package com.epam.vote.domain.dto;

import com.epam.vote.domain.Restaurant;

public class RestaurantDto {
    private String id;
    private String name;
    private String address;

    public RestaurantDto(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.address = restaurant.getName();
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
}
