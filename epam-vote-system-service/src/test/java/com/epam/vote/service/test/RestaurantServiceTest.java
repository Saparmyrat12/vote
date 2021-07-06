package com.epam.vote.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.repository.IRestaurantRepository;
import com.epam.vote.service.impl.RestaurantService;
import com.epam.vote.service.util.UidGenerator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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
@RunWith(PowerMockRunner.class)
@PrepareForTest({UidGenerator.class})
public class RestaurantServiceTest {

    private static final String UID = "c9fc058d-96f4-4181-958d-dd754b762d7e";

    @Before
    public void setUp(){
        PowerMockito.mockStatic(UidGenerator.class);
        PowerMockito.when(UidGenerator.generate()).thenReturn(UID);
    }

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
    public void testSaveRestaurant() {
        Restaurant expectedRestaurant = new Restaurant("", "McDonald's",
            "Dostoevsky avenue 75");
        doNothing().when(restaurantRepository).saveRestaurant(expectedRestaurant);
        when(UidGenerator.generate()).thenReturn(UID);
        Restaurant actualRestaurant = restaurantService.saveRestaurant(expectedRestaurant);
        assertEquals(UID, actualRestaurant.getId());
        assertEquals("McDonald's", actualRestaurant.getName());
        assertEquals("Dostoevsky avenue 75", actualRestaurant.getAddress());
        assertEquals("system", actualRestaurant.getCreatedUser());
        verify(restaurantRepository, times(1)).saveRestaurant(expectedRestaurant);
    }
}
