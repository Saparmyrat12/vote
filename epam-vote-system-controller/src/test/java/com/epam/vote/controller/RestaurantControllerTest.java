package com.epam.vote.controller;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.domain.dto.RestaurantDto;
import com.epam.vote.service.impl.RestaurantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Test Restaurant controller
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 30, 2021
 * @author Sapar
 */
@RunWith(MockitoJUnitRunner.class)
public class RestaurantControllerTest {

    @InjectMocks
    private RestaurantController restaurantController;

    @Mock
    private RestaurantService restaurantService;

    @Test
    public void testGetAllRestaurant() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("39c1abd4-e9dc-43a0-90aa-441be8e9f8e7", "Burger King",
                "881 Doe Crossing Lane"));
        when(restaurantService.getAllRestaurants()).thenReturn(restaurants);
        ResponseEntity<List<RestaurantDto>> restaurantDtos = restaurantController.getAllRestaurants();
        RestaurantDto restaurantDto = restaurantDtos.getBody().get(0);
        assertEquals(true, restaurantDtos.getStatusCode().is2xxSuccessful());
        assertEquals(1, restaurantDtos.getBody().size());
        assertEquals("Burger King", restaurantDto.getName());
        assertEquals("39c1abd4-e9dc-43a0-90aa-441be8e9f8e7", restaurantDto.getId());
        assertEquals("881 Doe Crossing Lane", restaurantDto.getAddress());
        assertNotNull(restaurantController.getAllRestaurants());
        verify(restaurantService, times(2)).getAllRestaurants();
    }
}
