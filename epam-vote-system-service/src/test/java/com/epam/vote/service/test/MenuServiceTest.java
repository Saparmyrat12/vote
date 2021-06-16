package com.epam.vote.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.vote.domain.Menu;
import com.epam.vote.repository.IMenuRepository;
import com.epam.vote.service.impl.MenuService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * Test for {@link MenuService}.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 11, 2021
 * @author Sapar
 */
@RunWith(MockitoJUnitRunner.class)
public class MenuServiceTest {

    @InjectMocks
    private MenuService menuService;

    @Mock
    private IMenuRepository menuRepository;

    @Test
    public void testGetMenuOfRestaurant() {
        List<Menu> menuListRepository = Collections.singletonList(
            new Menu("550b17ef-389a-47a1-af76-1fb53373da68", "pizza", BigDecimal.valueOf(5.55)));
        when(menuRepository.findMenuOfRestaurant("KFC")).thenReturn(menuListRepository);
        List<Menu> menuListService = menuService.getMenuOfRestaurant("KFC");
        assertEquals(1, menuListService.size());
        Menu menu = menuListService.get(0);
        assertEquals("550b17ef-389a-47a1-af76-1fb53373da68", menu.getId());
        assertEquals("pizza", menu.getName());
        assertEquals(new BigDecimal("5.55"), menu.getPrice());
        assertNotNull(menuListService);
        verify(menuRepository, times(1)).findMenuOfRestaurant("KFC");
    }
}
