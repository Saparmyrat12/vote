package com.epam.vote.service.impl;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.repository.IRestaurantRepository;
import com.epam.vote.service.IRestaurantService;
import com.epam.vote.service.exception.InternalException;
import com.epam.vote.service.util.UidGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link IRestaurantService}.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 26, 2021
 * @author Sapar
 */
@Service
public class RestaurantService implements IRestaurantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);

    @Autowired
    private IRestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAllRestaurants();
        LOGGER.info("getAllRestaurants size = {}", restaurants.size());
        if (restaurants.isEmpty()) {
            throw new InternalException("The list of restaurants is empty");
        }
        return restaurants;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        restaurant.setId(UidGenerator.generate());
        restaurantRepository.saveRestaurant(restaurant);
        LOGGER.info("createRestaurant {}  {}", restaurant.getId(), restaurant.getCreatedUser());
        return restaurant;
    }
}
