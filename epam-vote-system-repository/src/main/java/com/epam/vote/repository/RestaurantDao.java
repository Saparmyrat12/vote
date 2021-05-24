/**
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 20, 2021
 *
 * @author Sapar
 */
package com.epam.vote.repository;

import com.epam.vote.domain.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantDao {
    List<Restaurant> selectAllRestaurant();
}
