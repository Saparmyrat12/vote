package com.epam.vote.controller;

import com.epam.vote.domain.dto.RestaurantDto;
import com.epam.vote.service.impl.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Restaurant controller.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 24, 2021
 * @author Sapar
 */
@RestController
@RequestMapping(value = "/restaurant", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        List<RestaurantDto> restaurantDtoList = restaurantService.getAllRestaurants().stream()
            .map(RestaurantDto::new).collect(Collectors.toList());
        return !restaurantDtoList.isEmpty()
            ? new ResponseEntity<>(restaurantDtoList, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
