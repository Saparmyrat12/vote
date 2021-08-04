package com.epam.vote.service;

import com.epam.vote.domain.Menu;

import java.util.List;

/**
 * Interface Menu service.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 11, 2021
 * @author Sapar
 */
public interface IMenuService {

    /**
     * This method returns list menu of restaurant.
     * @param restaurantId id of restaurant.
     * @return list of {@link Menu}'s.
     */
    List<Menu> getMenuOfRestaurant(String restaurantId);

    /**
     * This method saves the new dish.
     * @param menu instance of {@link Menu}.
     * @return {@link Menu}'s.
     */
    Menu saveMenu(Menu menu);

    /**
     * This method saves a new dish in the restaurant menu.
     * @param menu instance of {@link Menu}.
     * @param restaurantId id of restaurant.
     * @return {@link Menu}'s.
     */
    Menu saveMenuToRestaurant(Menu menu, String restaurantId);
}
