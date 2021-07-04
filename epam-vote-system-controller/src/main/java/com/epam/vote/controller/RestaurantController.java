package com.epam.vote.controller;

import com.epam.vote.domain.Restaurant;
import com.epam.vote.domain.dto.MenuDto;
import com.epam.vote.domain.dto.RestaurantDto;
import com.epam.vote.service.convertor.RestaurantConvertor;
import com.epam.vote.service.impl.MenuService;
import com.epam.vote.service.impl.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        List<RestaurantDto> restaurantDtoList = restaurantService.getAllRestaurants().stream()
            .map(RestaurantDto::new).collect(Collectors.toList());
        return !restaurantDtoList.isEmpty()
            ? new ResponseEntity<>(restaurantDtoList, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}/menu")
    public ResponseEntity<List<MenuDto>> getMenuOfRestaurant(@PathVariable(name = "id") String id) {
        List<MenuDto> menuDtoList = menuService.getMenuOfRestaurant(id).stream()
            .map(MenuDto::new).collect(Collectors.toList());
        return !menuDtoList.isEmpty()
            ? new ResponseEntity<>(menuDtoList, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @PreAuthorize(value = "@restaurantValidator.isNotExists(#restaurantDto)")
    public ResponseEntity<RestaurantDto> createRestaurant(@Valid @RequestBody RestaurantDto restaurantDto) {
        Restaurant restaurant = RestaurantConvertor.toRestaurant(restaurantDto);
        restaurantService.saveRestaurant(restaurant);
        return new ResponseEntity<>(restaurantDto, HttpStatus.CREATED);
    }
}
