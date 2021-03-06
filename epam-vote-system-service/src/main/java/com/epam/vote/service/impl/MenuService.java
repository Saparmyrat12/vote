package com.epam.vote.service.impl;

import com.epam.vote.domain.Menu;
import com.epam.vote.repository.IMenuRepository;
import com.epam.vote.repository.IRestaurantDishMapRepository;
import com.epam.vote.service.IMenuService;
import com.epam.vote.service.exception.InternalException;
import com.epam.vote.service.util.UidGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link IMenuService}.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 11, 2021
 * @author Sapar
 */
@Service
public class MenuService implements IMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuService.class);

    @Autowired
    private IMenuRepository menuRepository;

    @Autowired
    private IRestaurantDishMapRepository restaurantDishMapRepository;

    @Override
    public List<Menu> getMenuOfRestaurant(String restaurantId) {
        List<Menu> menus = menuRepository.findMenuOfRestaurant(restaurantId);
        LOGGER.info("getMenuOfRestaurant size = {}", menus.size());
        if (menus.isEmpty()) {
            throw new InternalException("The restaurant menu is empty");
        }
        return menus;
    }

    @Override
    @Transactional
    public Menu save(Menu menu, String restaurantId) {
        menu.setId(UidGenerator.generate());
        menuRepository.saveMenu(menu);
        restaurantDishMapRepository.saveMenuToRestaurant(menu, restaurantId);
        LOGGER.info("save {} {} {}", menu.getId(), restaurantId, menu.getCreatedUser());
        return menu;
    }
}
