package com.epam.vote.service.impl;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.repository.IRestaurantRepository;
import com.epam.vote.service.IRestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Restaurant service.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 26, 2021
 * @author Sapar
 */
@Service
public class RestaurantService implements IRestaurantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);

    @Autowired
    private IRestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        LOGGER.info("getAllRestaurants is started");
        return restaurantRepository.findAllRestaurants();
    }
}
