package com.epam.vote.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.repository.IRestaurantRepository;
import com.epam.vote.service.impl.RestaurantService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

/**
 * Test for {@link RestaurantService}.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 30, 2021
 * @author Sapar
 */
@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceTest {

    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private IRestaurantRepository restaurantRepository;

    @Test
    public void testGetAllRestaurant() {
        List<Restaurant> expectedRestaurants =
            Collections.singletonList(new Restaurant("39c1abd4-e9dc-43a0-90aa-441be8e9f8e7", "Burger King",
                "881 Doe Crossing Lane"));
        when(restaurantRepository.findAllRestaurants()).thenReturn(expectedRestaurants);
        List<Restaurant> actualRestaurants = restaurantService.getAllRestaurants();
        assertEquals(1, actualRestaurants.size());
        Restaurant restaurant = actualRestaurants.get(0);
        assertNotNull(actualRestaurants);
        assertEquals("39c1abd4-e9dc-43a0-90aa-441be8e9f8e7", restaurant.getId());
        assertEquals("Burger King", restaurant.getName());
        assertEquals("881 Doe Crossing Lane", restaurant.getAddress());
        assertNotNull(actualRestaurants);
        verify(restaurantRepository, times(1)).findAllRestaurants();
    }

    @Test
    public void testCreateRestaurant() {
        Restaurant expectedRestaurant = new Restaurant("c9fc058d-96f4-4181-958d-dd754b762d7e", "McDonald's",
            "Dostoevsky avenue 75");
        Restaurant actualRestaurant = restaurantService.createRestaurant(expectedRestaurant);
        assertEquals("c9fc058d-96f4-4181-958d-dd754b762d7e", actualRestaurant.getId());
        assertEquals("McDonald's", actualRestaurant.getName());
        assertEquals("Dostoevsky avenue 75", actualRestaurant.getAddress());
        assertEquals("system", actualRestaurant.getCreatedUser());
    }
}
