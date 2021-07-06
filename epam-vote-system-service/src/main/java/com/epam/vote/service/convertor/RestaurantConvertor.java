package com.epam.vote.service.convertor;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.domain.dto.RestaurantDto;

/**
 * Restaurant Convertor.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июль 02, 2021
 * @author Sapar
 */
public class RestaurantConvertor {

    public static Restaurant convert(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDto.getId());
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        return restaurant;
    }
}
