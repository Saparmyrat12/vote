/**
 * This class describe method for controller.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 21, 2021
 * @author Sapar
 */
package com.epam.vote.service;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.repository.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    public List<Restaurant> selectAllRestaurant() {
        return restaurantDao.selectAllRestaurant();
    }
}
