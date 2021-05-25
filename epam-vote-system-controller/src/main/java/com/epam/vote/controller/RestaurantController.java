/**
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 24, 2021
 * @author Sapar
 */
package com.epam.vote.controller;

import com.epam.vote.domain.dto.RestaurantDto;
import com.epam.vote.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * This class handles requests from the client.
 */
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> get() {
        List<RestaurantDto> entities = StreamSupport
                .stream(restaurantService.selectAllRestaurant().spliterator(), false)
                .map(RestaurantDto::new).collect(Collectors.toList());
        if (entities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
