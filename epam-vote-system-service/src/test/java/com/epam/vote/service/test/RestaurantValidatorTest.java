package com.epam.vote.service.test;

import static org.mockito.Mockito.when;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.domain.dto.RestaurantDto;
import com.epam.vote.repository.IRestaurantRepository;
import com.epam.vote.service.exception.ValidationException;
import com.epam.vote.service.validator.RestaurantValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test for {@link RestaurantValidator}.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июль 01, 2021
 * @author Sapar
 */
@RunWith(MockitoJUnitRunner.class)
public class RestaurantValidatorTest {

    @InjectMocks
    private RestaurantValidator restaurantValidator;

    @Mock
    private IRestaurantRepository restaurantRepository;

    @Test(expected = ValidationException.class)
    public void testIsNotExists() {
        Restaurant restaurant = new Restaurant("c9fc058d-96f4-4181-958d-dd754b762d7e", "McDonald's",
            "Dostoevsky avenue 75");
        when(restaurantRepository.findByName("McDonald's")).thenReturn(restaurant);
        restaurantValidator.isNotExists(new RestaurantDto(restaurant));
    }
}
