/**
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 21, 2021
 * @author Sapar
 */
package com.epam.vote.service;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.repository.IRestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * This class describe method for controller.
 */
@Service
public class RestaurantService {

    @Autowired
    private IRestaurantDao restaurantDao;

    public List<Restaurant> selectAllRestaurant() {
        return restaurantDao.selectAllRestaurant();
    }
}
