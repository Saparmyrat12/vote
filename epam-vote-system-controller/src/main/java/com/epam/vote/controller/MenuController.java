package com.epam.vote.controller;

import com.epam.vote.domain.dto.MenuDto;
import com.epam.vote.service.impl.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Menu controller.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 15, 2021
 * @author Sapar
 */
@RestController
@RequestMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/{restaurantId}")
    public ResponseEntity<List<MenuDto>> getMenuOfRestaurant(
        @PathVariable(name = "restaurantId") String restaurantId) {
        List<MenuDto> menuDtoList = menuService.getMenuOfRestaurant(restaurantId).stream()
            .map(MenuDto::new).collect(Collectors.toList());
        return !menuDtoList.isEmpty()
            ? new ResponseEntity<>(menuDtoList, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
