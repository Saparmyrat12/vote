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
}
