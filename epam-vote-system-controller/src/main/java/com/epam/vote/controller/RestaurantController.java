package com.epam.vote.controller;

import com.epam.vote.domain.dto.RestaurantDto;
import com.epam.vote.service.impl.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Restaurant controller.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 24, 2021
 * @author Sapar
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        logger.info("getAllRestaurants is started");
        List<RestaurantDto> restaurantDtos = restaurantService.getAllRestaurants().stream()
                .map(RestaurantDto::new).collect(Collectors.toList());
        return restaurantDtos != null && !restaurantDtos.isEmpty()
                ? new ResponseEntity<>(restaurantDtos, HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
