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
        List<Restaurant> actualRestaurantList = repository.findAllRestaurants();
        assertEquals(2, actualRestaurantList.size());
        Restaurant actualRestaurant = actualRestaurantList.get(0);
        assertEquals("12c1abd4-e9dc-43a0-90aa-441be8e9f8e7", actualRestaurant.getId());
        assertEquals("KFC", actualRestaurant.getName());
        assertEquals("112 Doe Crossing Lane", actualRestaurant.getAddress());
    }

    @Test
    public void testCreateRestaurant() {
        Restaurant expectedRestaurant = new Restaurant("c9fc058d-96f4-4181-958d-dd754b762d7e", "McDonald's",
            "Dostoevsky avenue 75", "system", 1);
        int actualNumberOfRestaurants = repository.createRestaurant(expectedRestaurant);
        assertEquals(1, actualNumberOfRestaurants);
        Restaurant actualRestaurant = repository.findByRestaurantId("c9fc058d-96f4-4181-958d-dd754b762d7e");
        assertEquals("c9fc058d-96f4-4181-958d-dd754b762d7e", actualRestaurant.getId());
        assertEquals("McDonald's", actualRestaurant.getName());
        assertEquals("Dostoevsky avenue 75", actualRestaurant.getAddress());
        assertEquals("system", actualRestaurant.getCreatedUser());
        assertEquals(1, actualRestaurant.getRecordVersion());
    }
}
