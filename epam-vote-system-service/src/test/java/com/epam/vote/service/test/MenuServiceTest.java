package com.epam.vote.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.vote.domain.Menu;
import com.epam.vote.repository.IMenuRepository;
import com.epam.vote.repository.IRestaurantDishMapRepository;
import com.epam.vote.service.impl.MenuService;
import com.epam.vote.service.util.UidGenerator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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
@RunWith(PowerMockRunner.class)
@PrepareForTest({UidGenerator.class})
public class MenuServiceTest {

    private static final String UID = "aca93cfb-a294-49b9-ad6c-0db81f547922";

    @Before
    public void setUp() {
        PowerMockito.mockStatic(UidGenerator.class);
        PowerMockito.when(UidGenerator.generate()).thenReturn(UID);
    }

    @InjectMocks
    private MenuService menuService;

    @Mock
    private IMenuRepository menuRepository;

    @Mock
    private IRestaurantDishMapRepository restaurantDishMapRepository;

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

    @Test
    public void testSaveMenu() {
        Menu expectedMenu = new Menu();
        expectedMenu.setId("");
        expectedMenu.setName("Hot Dog");
        doNothing().when(menuRepository).saveMenu(expectedMenu);
        when(UidGenerator.generate()).thenReturn(UID);
        Menu actualMenu = menuService.saveMenu(expectedMenu);
        assertEquals(UID, actualMenu.getId());
        assertEquals("Hot Dog", actualMenu.getName());
        assertEquals("system", actualMenu.getCreatedUser());
        verify(menuRepository, times(1)).saveMenu(expectedMenu);
    }

    @Test
    public void testSaveMenuToRestaurant() {
        Menu expectedMenu = new Menu("", "Burger", new BigDecimal("7.55"));
        menuRepository.saveMenu(expectedMenu);
        doNothing().when(restaurantDishMapRepository)
            .saveMenuToRestaurant(expectedMenu, "b9c9fd2e-973e-425e-93a0-72cb547b2f66");
        when(UidGenerator.generate()).thenReturn(UID);
        Menu actualMenu = menuService.saveMenuToRestaurant(expectedMenu, "b9c9fd2e-973e-425e-93a0-72cb547b2f66");
        assertEquals(UID, actualMenu.getId());
        assertEquals("Burger", actualMenu.getName());
        assertEquals(new BigDecimal("7.55"), actualMenu.getPrice());
        verify(restaurantDishMapRepository, times(1)).saveMenuToRestaurant(expectedMenu,
            "b9c9fd2e-973e-425e-93a0-72cb547b2f66");
    }
}
