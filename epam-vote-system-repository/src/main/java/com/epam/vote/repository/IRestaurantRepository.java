package com.epam.vote.repository;

import com.epam.vote.domain.Restaurant;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Restaurant repository.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 20, 2021
 * @author Sapar
 */
@Repository
public interface IRestaurantRepository {

    /**
     * This method find all restaurants.
     * @return list of {@link Restaurant}'s.
     */
    List<Restaurant> findAllRestaurants();

    /**
     * This method create new restaurant.
     * @param restaurant instance of {@link Restaurant}.
     */
    void createRestaurant(Restaurant restaurant);

    /**
     * This method find restaurant by id.
     * @param id id restaurant.
     * @return {@link Restaurant}.
     */
    Restaurant findById(String id);
}
