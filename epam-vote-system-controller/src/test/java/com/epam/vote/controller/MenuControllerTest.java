package com.epam.vote.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.vote.domain.Menu;
import com.epam.vote.domain.dto.MenuDto;
import com.epam.vote.service.impl.MenuService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * Test for {@link MenuController}.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 15, 2021
 * @author Sapar
 */
@RunWith(MockitoJUnitRunner.class)
public class MenuControllerTest {

    @InjectMocks
    private MenuController menuController;

    @Mock
    private MenuService menuService;

    @Test
    public void testGetMenuOfRestaurant() {
        List<Menu> expectedMenus = Collections.singletonList(
            new Menu("550b17ef-389a-47a1-af76-1fb53373da68", "pizza", BigDecimal.valueOf(5.55)));
        when(menuService.getMenuOfRestaurant("12c1abd4-e9dc-43a0-90aa-441be8e9f8e7")).thenReturn(expectedMenus);
        ResponseEntity<List<MenuDto>> actualMenuDtoList =
            menuController.getMenuOfRestaurant("12c1abd4-e9dc-43a0-90aa-441be8e9f8e7");
        assertEquals(1, actualMenuDtoList.getBody().size());
        MenuDto actualMenuDto = actualMenuDtoList.getBody().get(0);
        assertTrue(actualMenuDtoList.getStatusCode().is2xxSuccessful());
        assertNotNull(actualMenuDtoList);
        assertEquals("550b17ef-389a-47a1-af76-1fb53373da68", actualMenuDto.getId());
        assertEquals("pizza", actualMenuDto.getName());
        assertEquals(new BigDecimal("5.55"), actualMenuDto.getPrice());
        verify(menuService, times(1)).getMenuOfRestaurant("12c1abd4-e9dc-43a0-90aa-441be8e9f8e7");
    }
}
