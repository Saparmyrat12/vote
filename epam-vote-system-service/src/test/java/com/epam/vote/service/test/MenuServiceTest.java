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
        List<Menu> expectedMenus = Collections.singletonList(
            new Menu("550b17ef-389a-47a1-af76-1fb53373da68", "pizza", BigDecimal.valueOf(5.55)));
        when(menuRepository.findMenuOfRestaurant("12c1abd4-e9dc-43a0-90aa-441be8e9f8e7")).thenReturn(expectedMenus);
        List<Menu> actualMenus = menuService.getMenuOfRestaurant("12c1abd4-e9dc-43a0-90aa-441be8e9f8e7");
        assertEquals(1, actualMenus.size());
        Menu menu = actualMenus.get(0);
        assertEquals("550b17ef-389a-47a1-af76-1fb53373da68", menu.getId());
        assertEquals("pizza", menu.getName());
        assertEquals(new BigDecimal("5.55"), menu.getPrice());
        assertNotNull(actualMenus);
        verify(menuRepository, times(1)).findMenuOfRestaurant("12c1abd4-e9dc-43a0-90aa-441be8e9f8e7");
    }
}