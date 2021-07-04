package com.epam.vote.service.convertor;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.domain.dto.RestaurantDto;

import org.springframework.stereotype.Service;

/**
 * Restaurant Convertor.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июль 02, 2021
 * @author Sapar
 */
@Service
public class RestaurantConvertor {

    public static Restaurant toRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDto.getId());
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        return restaurant;
    }
}