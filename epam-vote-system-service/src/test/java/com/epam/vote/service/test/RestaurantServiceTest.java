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
        List<Restaurant> restaurantListRepository =
            Collections.singletonList(new Restaurant("39c1abd4-e9dc-43a0-90aa-441be8e9f8e7", "Burger King",
                "881 Doe Crossing Lane"));
        when(restaurantRepository.findAllRestaurants()).thenReturn(restaurantListRepository);
        List<Restaurant> restaurantListService = restaurantService.getAllRestaurants();
        assertEquals(1, restaurantListService.size());
        Restaurant restaurant = restaurantListService.get(0);
        assertNotNull(restaurantListService);
        assertEquals("39c1abd4-e9dc-43a0-90aa-441be8e9f8e7", restaurant.getId());
        assertEquals("Burger King", restaurant.getName());
        assertEquals("881 Doe Crossing Lane", restaurant.getAddress());
        assertNotNull(restaurantService.getAllRestaurants());
        verify(restaurantRepository, times(2)).findAllRestaurants();
    }
}
