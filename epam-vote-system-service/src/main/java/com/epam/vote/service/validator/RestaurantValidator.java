package com.epam.vote.service.validator;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.domain.dto.RestaurantDto;
import com.epam.vote.repository.IRestaurantRepository;
import com.epam.vote.service.exception.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Restaurant Validator.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 30, 2021
 * @author Sapar
 */
@Service("restaurantValidator")
public class RestaurantValidator {

    @Autowired
    private IRestaurantRepository repository;

    public boolean isNotExists(RestaurantDto registrationRestaurant) {
        Restaurant restaurant = repository.findByName(registrationRestaurant.getName());
        if (null == restaurant) {
            return true;
        }
        throw new ValidationException("Restaurant already exists.");
    }
}
