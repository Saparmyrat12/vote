package com.epam.vote.repository.testInteg;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.repository.IRestaurantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test IRestaurantRepository.
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
    public void findAllRestaurants() {
        List<Restaurant> restaurants = repository.findAllRestaurants();
        Restaurant restaurant = restaurants.get(0);
        assertNotNull(restaurants);
        assertEquals(1, restaurants.size());
        assertEquals("12c1abd4-e9dc-43a0-90aa-441be8e9f8e7", restaurant.getId());
        assertEquals("KFC", restaurant.getName());
        assertEquals("112 Doe Crossing Lane", restaurant.getAddress());
    }
}
