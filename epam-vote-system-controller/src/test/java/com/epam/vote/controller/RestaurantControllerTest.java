package com.epam.vote.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.domain.dto.RestaurantDto;
import com.epam.vote.service.impl.RestaurantService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

/**
 * Test for {@link RestaurantController}.
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
        List<Restaurant> expectedRestaurants =
            Collections.singletonList(new Restaurant("39c1abd4-e9dc-43a0-90aa-441be8e9f8e7", "Burger King",
                "881 Doe Crossing Lane"));
        when(restaurantService.getAllRestaurants()).thenReturn(expectedRestaurants);
        ResponseEntity<List<RestaurantDto>> actualRestaurantDtoList = restaurantController.getAllRestaurants();
        assertEquals(1, actualRestaurantDtoList.getBody().size());
        RestaurantDto actualRestaurantDto = actualRestaurantDtoList.getBody().get(0);
        assertNotNull(actualRestaurantDtoList);
        assertTrue(actualRestaurantDtoList.getStatusCode().is2xxSuccessful());
        assertEquals("Burger King", actualRestaurantDto.getName());
        assertEquals("39c1abd4-e9dc-43a0-90aa-441be8e9f8e7", actualRestaurantDto.getId());
        assertEquals("881 Doe Crossing Lane", actualRestaurantDto.getAddress());
        verify(restaurantService, times(1)).getAllRestaurants();
    }
}
