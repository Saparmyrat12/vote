package com.epam.vote.repository;

import com.epam.vote.domain.Menu;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Menu repository.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 09, 2021
 * @author Sapar
 */
@Repository
public interface IMenuRepository {

    /**
     * This method finds menu of restaurant.
     * @param restaurantId id of restaurant.
     * @return list of {@link Menu}'s.
     */
    List<Menu> findMenuOfRestaurant(String restaurantId);

    /**
     * This method saves the new dish.
     * @param menu instance of {@link Menu}.
     */
    void saveMenu(Menu menu);
}
