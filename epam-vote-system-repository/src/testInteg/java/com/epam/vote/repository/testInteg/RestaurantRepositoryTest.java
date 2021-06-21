package com.epam.vote.repository.testInteg;

import static org.junit.Assert.assertEquals;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.repository.IRestaurantRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Test for {@link IRestaurantRepository}.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 05, 2021
 * @author Sapar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmbeddedPostgresConfig.class)
public class RestaurantRepositoryTest {

    @Autowired
    private IRestaurantRepository repository;

    @Test
    public void testFindAllRestaurants() {
        List<Restaurant> restaurants = repository.findAllRestaurants();
        assertEquals(2, restaurants.size());
        Restaurant restaurant = restaurants.get(0);
        assertEquals("12c1abd4-e9dc-43a0-90aa-441be8e9f8e7", restaurant.getId());
        assertEquals("KFC", restaurant.getName());
        assertEquals("112 Doe Crossing Lane", restaurant.getAddress());
    }

    @Test
    public void testCreateRestaurant() {
        Restaurant restaurant = new Restaurant("c9fc058d-96f4-4181-958d-dd754b762d7e", "McDonald's",
            "Dostoevsky avenue 75", "system", 1);
        int a = repository.createRestaurant(restaurant);
        assertEquals(1, a);
    }
}
