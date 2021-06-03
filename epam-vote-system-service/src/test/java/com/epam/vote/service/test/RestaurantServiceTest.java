package com.epam.vote.service.test;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.repository.IRestaurantRepository;
import com.epam.vote.service.impl.RestaurantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Test Restaurant service.
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
        List<Restaurant> restaurantListRepository = new ArrayList<>();
        restaurantListRepository.add(new Restaurant("39c1abd4-e9dc-43a0-90aa-441be8e9f8e7", "Burger King",
                "881 Doe Crossing Lane"));
        when(restaurantRepository.findAllRestaurants()).thenReturn(restaurantListRepository);
        List<Restaurant> restaurantListService = restaurantService.getAllRestaurants();
        Restaurant restaurant = restaurantListService.get(0);
        assertNotNull(restaurantListService);
        assertEquals(1, restaurantListService.size());
        assertEquals("39c1abd4-e9dc-43a0-90aa-441be8e9f8e7", restaurant.getId());
        assertEquals("Burger King", restaurant.getName());
        assertEquals("881 Doe Crossing Lane", restaurant.getAddress());
        assertNotNull(restaurantService.getAllRestaurants());
        verify(restaurantRepository, times(4)).findAllRestaurants();
    }
}
