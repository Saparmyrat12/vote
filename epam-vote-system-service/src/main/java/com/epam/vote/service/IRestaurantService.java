package com.epam.vote.service;

import com.epam.vote.domain.Restaurant;

import java.util.List;

/**
 * Interface Restaurant service.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 26, 2021
 * @author Sapar
 */
public interface IRestaurantService {

    /**
     * This method returns a list of all restaurants.
     * @return list of {@link Restaurant}'s.
     */
    List<Restaurant> getAllRestaurants();

    /**
     * This method saves the new restaurant.
     * @param restaurant instance of {@link Restaurant}.
     * @return {@link Restaurant}.
     */
    Restaurant saveRestaurant(Restaurant restaurant);
}
