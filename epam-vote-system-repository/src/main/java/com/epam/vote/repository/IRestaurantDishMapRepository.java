package com.epam.vote.repository;

import com.epam.vote.domain.Menu;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * IRestaurantDishMap repository.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июль 15, 2021
 * @author Sapar
 */
@Repository
public interface IRestaurantDishMapRepository {

    /**
     * This method saves a new dish in the restaurant menu.
     * @param menu instance of {@link Menu}.
     * @param restaurantId id of restaurant.
     */
    void saveMenuToRestaurant(@Param("menu") Menu menu, @Param("restaurantId") String restaurantId);
}
