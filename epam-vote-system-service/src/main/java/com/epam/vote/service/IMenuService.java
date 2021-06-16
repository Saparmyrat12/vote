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
     * This method return list menu of restaurant.
     * @param idRestaurant id restaurant.
     * @return list of {@link Menu}'s.
     */
    List<Menu> getMenuOfRestaurant(String idRestaurant);
}
